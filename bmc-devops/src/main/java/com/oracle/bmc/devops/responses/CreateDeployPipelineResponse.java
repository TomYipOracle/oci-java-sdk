/**
 * Copyright (c) 2016, 2022, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.devops.responses;

import com.oracle.bmc.devops.model.*;

@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20210630")
@lombok.Builder(builderClassName = "Builder")
@lombok.ToString(callSuper = true)
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.Getter
public class CreateDeployPipelineResponse extends com.oracle.bmc.responses.BmcResponse {
    /**
     * Relative URL of the newly created resource.
     */
    private String location;

    /**
     * Unique Oracle-assigned identifier for the asynchronous request. You can use this to query status of the asynchronous operation.
     */
    private String opcWorkRequestId;

    /**
     * For optimistic concurrency control. See {@code if-match}.
     */
    private String etag;

    /**
     * Unique Oracle-assigned identifier for the request. If you need to contact Oracle about a particular request, provide the request ID.
     */
    private String opcRequestId;

    /**
     * The returned DeployPipeline instance.
     */
    private com.oracle.bmc.devops.model.DeployPipeline deployPipeline;

    @java.beans.ConstructorProperties({
        "__httpStatusCode__",
        "location",
        "opcWorkRequestId",
        "etag",
        "opcRequestId",
        "deployPipeline"
    })
    private CreateDeployPipelineResponse(
            int __httpStatusCode__,
            String location,
            String opcWorkRequestId,
            String etag,
            String opcRequestId,
            com.oracle.bmc.devops.model.DeployPipeline deployPipeline) {
        super(__httpStatusCode__);
        this.location = location;
        this.opcWorkRequestId = opcWorkRequestId;
        this.etag = etag;
        this.opcRequestId = opcRequestId;
        this.deployPipeline = deployPipeline;
    }

    public static class Builder {
        private int __httpStatusCode__;

        public Builder __httpStatusCode__(int __httpStatusCode__) {
            this.__httpStatusCode__ = __httpStatusCode__;
            return this;
        }

        /**
         * Copy method to populate the builder with values from the given instance.
         * @return this builder instance
         */
        public Builder copy(CreateDeployPipelineResponse o) {
            __httpStatusCode__(o.get__httpStatusCode__());
            location(o.getLocation());
            opcWorkRequestId(o.getOpcWorkRequestId());
            etag(o.getEtag());
            opcRequestId(o.getOpcRequestId());
            deployPipeline(o.getDeployPipeline());

            return this;
        }

        public CreateDeployPipelineResponse build() {
            return new CreateDeployPipelineResponse(
                    __httpStatusCode__,
                    location,
                    opcWorkRequestId,
                    etag,
                    opcRequestId,
                    deployPipeline);
        }
    }
}
