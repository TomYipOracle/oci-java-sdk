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
public class GetRepositoryFileLinesResponse extends com.oracle.bmc.responses.BmcResponse {
    /**
     * Unique Oracle-assigned identifier for the request. If you need to contact Oracle about a particular request, provide the request ID.
     */
    private String opcRequestId;

    /**
     * For optimistic concurrency control. See {@code if-match}.
     */
    private String etag;

    /**
     * This API will be deprecated on Wed, 29 Mar 2023 01:00:00 GMT. Please use "/repositories/{repositoryId}/file/lines"
     */
    private String sunset;

    /**
     * The returned RepositoryFileLines instance.
     */
    private com.oracle.bmc.devops.model.RepositoryFileLines repositoryFileLines;

    @java.beans.ConstructorProperties({
        "__httpStatusCode__",
        "opcRequestId",
        "etag",
        "sunset",
        "repositoryFileLines"
    })
    private GetRepositoryFileLinesResponse(
            int __httpStatusCode__,
            String opcRequestId,
            String etag,
            String sunset,
            com.oracle.bmc.devops.model.RepositoryFileLines repositoryFileLines) {
        super(__httpStatusCode__);
        this.opcRequestId = opcRequestId;
        this.etag = etag;
        this.sunset = sunset;
        this.repositoryFileLines = repositoryFileLines;
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
        public Builder copy(GetRepositoryFileLinesResponse o) {
            __httpStatusCode__(o.get__httpStatusCode__());
            opcRequestId(o.getOpcRequestId());
            etag(o.getEtag());
            sunset(o.getSunset());
            repositoryFileLines(o.getRepositoryFileLines());

            return this;
        }

        public GetRepositoryFileLinesResponse build() {
            return new GetRepositoryFileLinesResponse(
                    __httpStatusCode__, opcRequestId, etag, sunset, repositoryFileLines);
        }
    }
}
