import com.oracle.bmc.ConfigFileReader;
import com.oracle.bmc.Region;
import com.oracle.bmc.auth.AuthenticationDetailsProvider;
import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;
import com.oracle.bmc.datascience.DataScienceClient;
import com.oracle.bmc.datascience.model.CreateJobDetails;
import com.oracle.bmc.datascience.model.CreateJobRunDetails;
import com.oracle.bmc.datascience.model.DefaultJobConfigurationDetails;
import com.oracle.bmc.datascience.model.JobLifecycleState;
import com.oracle.bmc.datascience.model.JobLogConfigurationDetails;
import com.oracle.bmc.datascience.model.JobRunLifecycleState;
import com.oracle.bmc.datascience.model.JobShapeConfigDetails;
import com.oracle.bmc.datascience.model.JobSummary;
import com.oracle.bmc.datascience.model.ManagedEgressStandaloneJobInfrastructureConfigurationDetails;
import com.oracle.bmc.datascience.requests.CreateJobArtifactRequest;
import com.oracle.bmc.datascience.requests.CreateJobRequest;
import com.oracle.bmc.datascience.requests.CreateJobRunRequest;
import com.oracle.bmc.datascience.requests.DeleteJobRequest;
import com.oracle.bmc.datascience.requests.GetJobRequest;
import com.oracle.bmc.datascience.requests.GetJobRunRequest;
import com.oracle.bmc.datascience.requests.ListJobsRequest;
import com.oracle.bmc.datascience.responses.CreateJobArtifactResponse;
import com.oracle.bmc.datascience.responses.CreateJobResponse;
import com.oracle.bmc.datascience.responses.CreateJobRunResponse;
import com.oracle.bmc.datascience.responses.DeleteJobResponse;
import com.oracle.bmc.datascience.responses.GetJobResponse;
import com.oracle.bmc.datascience.responses.GetJobRunResponse;
import com.oracle.bmc.datascience.responses.ListJobsResponse;
import com.oracle.bmc.model.BmcException;
import com.oracle.bmc.responses.BmcResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DataScienceJobExample {

    static String configurationFilePath = "~/.oci/config";
    static String profile = "DEFAULT";
    static Long pollInterval = 5000L;
    static String compartmentId = "ocid1.compartment.oc1..aaaaaaaangv63635canrzwktk53434kb4oj47mpxgzvodzi6bx65p6c4wdwq";
    static String projectId = "ocid1.datascienceproject.oc1.iad.amaaaaaae5yt27aaobix6vgqwndlfune2rspgxdfzwfynhy43xutv65i4hvq";
    static String logGroupId = "ocid1.loggroup.oc1.iad.amaaaaaae5yt27aa7qaoom3b3nq77ltrzums2a5zadolz4w3ahaqqo27cdaq";
    static String artifactFilePath = "/Users/tyip/src/poc/ds_js/HelloWorld.sh";
    static String computeShape = "VM.Standard.E3.Flex";
    //static String computeShape = "VM.Standard.E4.Flex";

    static int concurrentTasks = 120;
    static int maxJobRetryCount = 5;

    static long[] jobElapseTimes = new long[concurrentTasks];
    static int[] jobRetryCount = new int[concurrentTasks];

    static Logger logger = LoggerFactory.getLogger(DataScienceJobExample.class);

    public static void main(String[] args) throws Exception {
        DataScienceClient client = CreateDSClient();

        String flag = (args.length == 0 || args[0].trim().isEmpty()) ? "1" : args[0].trim();
        switch(flag) {
            case "1":
                RunJobsInParallel(client);
                break;
            case "2":
                ListAndDeleteAllJobs(client);
                break;
            default:
                throw new IllegalArgumentException("Invalid first argument.");
        }
    }

    static DataScienceClient CreateDSClient() throws IOException {
        // Configuring the AuthenticationDetailsProvider. It's assuming there is a default OCI
        // config file
        // "~/.oci/config", and a profile in that config with the name "DEFAULT". Make changes to
        // the following
        // line if needed and use ConfigFileReader.parse(configurationFilePath, profile);

        final ConfigFileReader.ConfigFile configFile = ConfigFileReader.parseDefault();

        final AuthenticationDetailsProvider provider =
                new ConfigFileAuthenticationDetailsProvider(configFile);

        DataScienceClient client = DataScienceClient.builder().region(Region.US_ASHBURN_1).build(provider);

        logger.info("Data Science client created.");

        return client;
    }

    static String CreateJobNamePrefix(){
        DateTimeFormatter dtFormatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd-HH-mm-ss")
                .withZone(ZoneId.from(ZoneOffset.UTC));
        String timeStamp = dtFormatter.format(Instant.now());

        return "poc-job-" + timeStamp;
    }

    static void ListAndDeleteAllJobs(DataScienceClient client){

        ListJobsResponse response;
        try{
             response = client.listJobs(ListJobsRequest.builder()
                    .compartmentId(compartmentId)
                    .projectId(projectId)
                    .build());
        }
        catch (BmcException be) {
            logger.error("Error occured while listing jobs in compartment " + compartmentId + ", project " + projectId, be);
            throw be;
        }

        try {
            for (JobSummary jobSummary : response.getItems()) {
                if(jobSummary.getLifecycleState() != JobLifecycleState.Deleting &&
                        jobSummary.getLifecycleState() != JobLifecycleState.Deleted) {
                    logger.info("Deleting job: " + jobSummary.getId());
                    DeleteJob(client, jobSummary.getId());
                }
            }
        }
        catch (BmcException be) {
            logger.error("Error occured while deleting job in compartment " + compartmentId + ", project " + projectId, be);
            throw be;
        }
    }

    static void RunJobsInParallel(DataScienceClient client) throws InterruptedException{
        String jobNamePrefix = CreateJobNamePrefix();

        Runnable[] threadTasks = new Runnable[concurrentTasks];

        for(int i=0; i<concurrentTasks; i++){
            final int id = i;
            jobRetryCount[i] = 0;
            threadTasks[i] = () -> {
                try{
                    RunOneJob(client, jobNamePrefix, id);
                }
                catch(IOException ioe){
                    logger.error(ioe.getMessage());
                    throw new RuntimeException(ioe);
                }
                catch(InterruptedException ie){
                    logger.info("Interrupting Thread [{}].", Thread.currentThread().getName());
                    Thread.currentThread().interrupt();;
                }
            };
        }

        Instant overallStartTime = Instant.now();

        Thread[] workerThreads = new Thread[concurrentTasks];
        for(int i=0; i<concurrentTasks; i++){
            workerThreads[i] = new Thread(threadTasks[i]);
            workerThreads[i].start();
        }

        for(int i=0; i<concurrentTasks; i++) {
            workerThreads[i].join();
        }

        logger.info("All jobs completed. Elapse time: {} seconds.",
                Duration.between(overallStartTime, Instant.now()).getSeconds());

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<concurrentTasks; i++){
            sb.append(String.format("\nElapse time for [%s]: %d", workerThreads[i].getName(), jobElapseTimes[i]));
        }
        logger.info(sb.toString());
    }

    static void RunOneJob(DataScienceClient client,
                          String jobNamePrefix,
                          int id) throws  InterruptedException, IOException{
        Instant jobStartTime = Instant.now();

        String jobName = jobNamePrefix + "-" + Thread.currentThread().getName();

        // Create Job
        String jobId;
        try {
            jobId = CreateJob(client, compartmentId, projectId, logGroupId, jobName);
        }
        catch(Exception e){
            logger.error("Failed to create job.", e);
            throw e;
        }

        // Create Job artifact
        try {
            CreateJobArtifact(client, jobId, artifactFilePath);
        }
        catch(Exception e){
            logger.error("Failed to create job artifact.", e);
            DeleteJobAndPoll(client, jobId, id, jobStartTime, jobName);
            throw e;
        }

        // Start Job
        String jobRunId;
        try {
            jobRunId = RunJob(client, compartmentId, projectId, jobId);
        }
        catch(BmcException be){
            logger.error("Failed to start a job run -> BMC Exception.", be);
            DeleteJobAndPoll(client, jobId, id, jobStartTime, jobName);
            throw be;
        }

        try{
            JobRunLifecycleState currentJobRunState = JobRunLifecycleState.UnknownEnumValue;
            do{
                Thread.sleep(pollInterval);
                currentJobRunState = GetJobRunState(client, jobRunId);
            }while(currentJobRunState != JobRunLifecycleState.Succeeded);
        }
        catch(BmcException be){
            logger.error("Failed to get job run state. Will continue to retry. -> BMC Exception.", be);
            jobRetryCount[id]++;

            if(jobRetryCount[id] > maxJobRetryCount){
                logger.error("Exhausted all retry attempts. Bailing out...");
                DeleteJobAndPoll(client, jobId, id, jobStartTime, jobName);
                throw be;
            }
        }

        DeleteJobAndPoll(client, jobId, id, jobStartTime, jobName);
    }

    static void DeleteJobAndPoll(DataScienceClient client,
                                 String jobId,
                                 int threadId,
                                 Instant jobStartTime,
                                 String jobName) throws InterruptedException{
        try{
            DeleteJob(client, jobId);
        }
        catch(BmcException be) {
            logger.error("Failed to delete job.", be);
            throw be;
        }

        JobLifecycleState currentJobState = JobLifecycleState.UnknownEnumValue;
        do{
            Thread.sleep(pollInterval);
            try{
                currentJobState = GetJobLifecycleState(client, jobId);
            }
            catch(BmcException be){
                logger.error("Failed to get job deletion state. Will continue to retry. -> BMC Exception.", be);
                jobRetryCount[threadId]++;

                if(jobRetryCount[threadId] > maxJobRetryCount){
                    logger.error("Exhausted all retry attempts. Bailing out...");
                    logJobBailoutElapseTime(threadId, jobStartTime, jobName);
                    throw be;
                }
            }
        }while(currentJobState != JobLifecycleState.Deleted);

        jobElapseTimes[threadId] = Duration.between(jobStartTime, Instant.now()).getSeconds();
        logger.info("Job '{}' deleted. Elapse time: {} seconds.",
                jobName,
                jobElapseTimes[threadId]);
    }

    static void logJobBailoutElapseTime(int threadId, Instant jobStartTime, String jobName){
        jobElapseTimes[threadId] = Duration.between(jobStartTime, Instant.now()).getSeconds();
        logger.info("Job '{}' failed and terminated unexpectedly. Elapse time: {} seconds.",
                jobName,
                jobElapseTimes[threadId]);
    }

    static String CreateJob(DataScienceClient client, String compartmentId, String projectId, String logGroupId, String displayName){
        CreateJobDetails createJobDetails = CreateJobDetails.builder()
                .compartmentId(compartmentId)
                .projectId(projectId)
                .displayName(displayName)
                .description("POC of using OCI SDK to create a job.")
                .jobConfigurationDetails(DefaultJobConfigurationDetails.builder()
                        .build())
                .jobInfrastructureConfigurationDetails(ManagedEgressStandaloneJobInfrastructureConfigurationDetails.builder()
                        .shapeName(computeShape)
                        .blockStorageSizeInGBs(50)
                        .jobShapeConfigDetails(JobShapeConfigDetails.builder()
                                .ocpus(1f)
                                .memoryInGBs(16f).build())
                        .build())
                .jobLogConfigurationDetails(JobLogConfigurationDetails.builder()
                        .enableLogging(true)
                        .enableAutoLogCreation(true)
                        .logGroupId(logGroupId)
                        .build())
                .build();

        CreateJobRequest request = CreateJobRequest.builder()
                .createJobDetails(createJobDetails).build();

        CreateJobResponse response = client.createJob(request);
        String jobId = response.getJob().getId();
        logger.info("Job '{}' created. Job OCID: {}",
                displayName,
                jobId);

        return jobId;
    }

    static void CreateJobArtifact(DataScienceClient client, String jobId, String filePath)
            throws IOException {

        File artifactFile = new File(filePath);

        CreateJobArtifactRequest createJobArtifactRequest = CreateJobArtifactRequest.builder()
                .jobId(jobId)
                .contentLength(artifactFile.length())// Create a Stream, for example, by calling a helper function like below.
                .jobArtifact(new FileInputStream(artifactFile))
                //.opcRequestId("G7HY7UB47MOHXELHE106<unique_ID>")
                //.opcRetryToken("EXAMPLE-opcRetryToken-Value")
                .contentDisposition("attachment; filename=" + artifactFile.getName())
                .build();

        /* Send request to the Client */
        CreateJobArtifactResponse response = client.createJobArtifact(createJobArtifactRequest);
        if(is_OK(response)) {
            logger.info("Job artifact updated.");
        }
        else{
            throw new RuntimeException(String.format("Unable to update job artifact for job ID: {}", jobId));
        }
    }

    static String RunJob(DataScienceClient client, String compartmentId, String projectId, String jobId){
        CreateJobRunDetails createJobRunDetails = CreateJobRunDetails.builder()
                .compartmentId(compartmentId)
                .projectId(projectId)
                .displayName("poc-job-run-" + Instant.now().toEpochMilli())
                .jobId(jobId)
//                .jobConfigurationOverrideDetails(DefaultJobConfigurationDetails.builder().build())
//                .jobLogConfigurationOverrideDetails(JobLogConfigurationDetails.builder().build())
//                .freeformTags()
//                .definedTags()
                .build();

        CreateJobRunRequest createJobRunRequest = CreateJobRunRequest.builder()
                .createJobRunDetails(createJobRunDetails)
//                .opcRequestId("V6GA59AHDRPFHRBYOLKA<unique_ID>")
//                .opcRetryToken("EXAMPLE-opcRetryToken-Value").build();
                .build();

        /* Send request to the Client */
        CreateJobRunResponse response = client.createJobRun(createJobRunRequest);

        if(is_OK(response)){
            String jobRunId = response.getJobRun().getId();
            logger.info("Job run created. OCID: {}", jobRunId);

            return jobRunId;
        }
        else{
            throw new RuntimeException(
                    String.format("[{}] Unable to create a job run for job ID: {}",
                        Thread.currentThread().getName(),
                        jobId));
        }
    }

    static JobRunLifecycleState GetJobRunState(DataScienceClient client, String jobRunId){
        GetJobRunRequest getJobRunRequest = GetJobRunRequest.builder()
                .jobRunId(jobRunId)
//                .opcRequestId("E1K57KMMOVCST2WNYFDO<unique_ID>")
                .build();

        /* Send request to the Client */
        GetJobRunResponse response = client.getJobRun(getJobRunRequest);

        if(is_OK(response)){
            JobRunLifecycleState state = response.getJobRun().getLifecycleState();
            logger.info("Job run state retrieved: {}", state.getValue());

            return state;
        }
        else{
            throw new RuntimeException(
                    String.format("[{}] Unable to retrieve job state for job run ID: {}",
                            Thread.currentThread().getName(),
                            jobRunId));
        }
    }

    static void DeleteJob(DataScienceClient client, String jobId){
        DeleteJobRequest deleteJobRequest = DeleteJobRequest.builder()
                .jobId(jobId)
                //.ifMatch("EXAMPLE-ifMatch-Value")
                //.opcRequestId("MIVBY9456G7FJUFHMXBW<unique_ID>")
                .deleteRelatedJobRuns(true)
                .build();

        /* Send request to the Client */
        DeleteJobResponse response = client.deleteJob(deleteJobRequest);

        if(is_OK(response)){
            logger.info("Job deletion request received. OPC request ID: {}", response.getOpcRequestId());
        }
        else{
            throw new RuntimeException(
                    String.format("[{}] Unable to delete job. Job ID: {}",
                            Thread.currentThread().getName(),
                            jobId));
        }
    }

    static JobLifecycleState GetJobLifecycleState(DataScienceClient client, String jobId){
        GetJobRequest getJobRequest = GetJobRequest.builder()
                .jobId(jobId)
                //.opcRequestId("BTEAKKSW430Y98IJDDRC<unique_ID>")
                .build();

        /* Send request to the Client */
        GetJobResponse response = client.getJob(getJobRequest);

        logger.info("Job state retrieved: {}", response.get__httpStatusCode__());

        if(is_OK(response)){
            JobLifecycleState state = response.getJob().getLifecycleState();
            logger.info("Job life cycle state retrieved: {}", state.getValue());

            return state;
        }
        else{
            throw new RuntimeException(
                    String.format("[{}] Unable to retrieve job life cycle state for job run ID: {}",
                            Thread.currentThread().getName(),
                            jobId));
        }
    }

    static private boolean is_OK(BmcResponse response){
        return response.get__httpStatusCode__() < 300;
    }
}