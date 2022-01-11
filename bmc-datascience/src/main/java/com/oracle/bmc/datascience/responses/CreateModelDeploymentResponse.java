/**
 * Copyright (c) 2016, 2022, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.datascience.responses;

import com.oracle.bmc.datascience.model.*;

@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20190101")
@lombok.Builder(builderClassName = "Builder")
@lombok.ToString(callSuper = true)
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.Getter
public class CreateModelDeploymentResponse extends com.oracle.bmc.responses.BmcResponse {
    /**
     * For optimistic concurrency control. See [ETags for Optimistic Concurrency Control](https://docs.cloud.oracle.com/iaas/Content/API/Concepts/usingapi.htm#eleven).
     *
     */
    private String etag;

    /**
     * The URI that identifies the entity described in the response body.
     *
     */
    private String location;

    /**
     * Unique Oracle assigned identifier for the request. If you need to contact
     * Oracle about a particular request, then provide the request ID.
     *
     */
    private String opcRequestId;

    /**
     * The [OCID](https://docs.cloud.oracle.com/iaas/Content/API/Concepts/identifiers.htm) of the work request. Use [GetWorkRequest](https://docs.cloud.oracle.com/api/#/en/workrequests/20160918/WorkRequest/GetWorkRequest)
     * with this ID to track the status of the request.
     *
     */
    private String opcWorkRequestId;

    /**
     * The returned ModelDeployment instance.
     */
    private com.oracle.bmc.datascience.model.ModelDeployment modelDeployment;

    @java.beans.ConstructorProperties({
        "__httpStatusCode__",
        "etag",
        "location",
        "opcRequestId",
        "opcWorkRequestId",
        "modelDeployment"
    })
    private CreateModelDeploymentResponse(
            int __httpStatusCode__,
            String etag,
            String location,
            String opcRequestId,
            String opcWorkRequestId,
            com.oracle.bmc.datascience.model.ModelDeployment modelDeployment) {
        super(__httpStatusCode__);
        this.etag = etag;
        this.location = location;
        this.opcRequestId = opcRequestId;
        this.opcWorkRequestId = opcWorkRequestId;
        this.modelDeployment = modelDeployment;
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
        public Builder copy(CreateModelDeploymentResponse o) {
            __httpStatusCode__(o.get__httpStatusCode__());
            etag(o.getEtag());
            location(o.getLocation());
            opcRequestId(o.getOpcRequestId());
            opcWorkRequestId(o.getOpcWorkRequestId());
            modelDeployment(o.getModelDeployment());

            return this;
        }

        public CreateModelDeploymentResponse build() {
            return new CreateModelDeploymentResponse(
                    __httpStatusCode__,
                    etag,
                    location,
                    opcRequestId,
                    opcWorkRequestId,
                    modelDeployment);
        }
    }
}
