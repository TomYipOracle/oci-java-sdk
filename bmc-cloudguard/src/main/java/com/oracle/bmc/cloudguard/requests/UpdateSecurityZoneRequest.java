/**
 * Copyright (c) 2016, 2022, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.cloudguard.requests;

import com.oracle.bmc.cloudguard.model.*;
/**
 * <b>Example: </b>Click <a href="https://docs.cloud.oracle.com/en-us/iaas/tools/java-sdk-examples/latest/cloudguard/UpdateSecurityZoneExample.java.html" target="_blank" rel="noopener noreferrer">here</a> to see how to use UpdateSecurityZoneRequest.
 */
@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20200131")
public class UpdateSecurityZoneRequest
        extends com.oracle.bmc.requests.BmcRequest<
                com.oracle.bmc.cloudguard.model.UpdateSecurityZoneDetails> {

    /**
     * The unique identifier of the security zone ({@code SecurityZone})
     */
    private String securityZoneId;

    /**
     * The unique identifier of the security zone ({@code SecurityZone})
     */
    public String getSecurityZoneId() {
        return securityZoneId;
    }
    /**
     * The security zone information to be updated.
     */
    private com.oracle.bmc.cloudguard.model.UpdateSecurityZoneDetails updateSecurityZoneDetails;

    /**
     * The security zone information to be updated.
     */
    public com.oracle.bmc.cloudguard.model.UpdateSecurityZoneDetails
            getUpdateSecurityZoneDetails() {
        return updateSecurityZoneDetails;
    }
    /**
     * For optimistic concurrency control. In the PUT or DELETE call
     * for a resource, set the {@code if-match} parameter to the value of the
     * etag from a previous GET or POST response for that resource.
     * The resource will be updated or deleted only if the etag you
     * provide matches the resource's current etag value.
     *
     */
    private String ifMatch;

    /**
     * For optimistic concurrency control. In the PUT or DELETE call
     * for a resource, set the {@code if-match} parameter to the value of the
     * etag from a previous GET or POST response for that resource.
     * The resource will be updated or deleted only if the etag you
     * provide matches the resource's current etag value.
     *
     */
    public String getIfMatch() {
        return ifMatch;
    }
    /**
     * The client request ID for tracing.
     */
    private String opcRequestId;

    /**
     * The client request ID for tracing.
     */
    public String getOpcRequestId() {
        return opcRequestId;
    }

    /**
     * Alternative accessor for the body parameter.
     * @return body parameter
     */
    @Override
    @com.oracle.bmc.InternalSdk
    public com.oracle.bmc.cloudguard.model.UpdateSecurityZoneDetails getBody$() {
        return updateSecurityZoneDetails;
    }

    public static class Builder
            implements com.oracle.bmc.requests.BmcRequest.Builder<
                    UpdateSecurityZoneRequest,
                    com.oracle.bmc.cloudguard.model.UpdateSecurityZoneDetails> {
        private com.oracle.bmc.util.internal.Consumer<javax.ws.rs.client.Invocation.Builder>
                invocationCallback = null;
        private com.oracle.bmc.retrier.RetryConfiguration retryConfiguration = null;

        /**
         * The unique identifier of the security zone ({@code SecurityZone})
         */
        private String securityZoneId = null;

        /**
         * The unique identifier of the security zone ({@code SecurityZone})
         * @param securityZoneId the value to set
         * @return this builder instance
         */
        public Builder securityZoneId(String securityZoneId) {
            this.securityZoneId = securityZoneId;
            return this;
        }

        /**
         * The security zone information to be updated.
         */
        private com.oracle.bmc.cloudguard.model.UpdateSecurityZoneDetails
                updateSecurityZoneDetails = null;

        /**
         * The security zone information to be updated.
         * @param updateSecurityZoneDetails the value to set
         * @return this builder instance
         */
        public Builder updateSecurityZoneDetails(
                com.oracle.bmc.cloudguard.model.UpdateSecurityZoneDetails
                        updateSecurityZoneDetails) {
            this.updateSecurityZoneDetails = updateSecurityZoneDetails;
            return this;
        }

        /**
         * For optimistic concurrency control. In the PUT or DELETE call
         * for a resource, set the {@code if-match} parameter to the value of the
         * etag from a previous GET or POST response for that resource.
         * The resource will be updated or deleted only if the etag you
         * provide matches the resource's current etag value.
         *
         */
        private String ifMatch = null;

        /**
         * For optimistic concurrency control. In the PUT or DELETE call
         * for a resource, set the {@code if-match} parameter to the value of the
         * etag from a previous GET or POST response for that resource.
         * The resource will be updated or deleted only if the etag you
         * provide matches the resource's current etag value.
         *
         * @param ifMatch the value to set
         * @return this builder instance
         */
        public Builder ifMatch(String ifMatch) {
            this.ifMatch = ifMatch;
            return this;
        }

        /**
         * The client request ID for tracing.
         */
        private String opcRequestId = null;

        /**
         * The client request ID for tracing.
         * @param opcRequestId the value to set
         * @return this builder instance
         */
        public Builder opcRequestId(String opcRequestId) {
            this.opcRequestId = opcRequestId;
            return this;
        }

        /**
         * Set the invocation callback for the request to be built.
         * @param invocationCallback the invocation callback to be set for the request
         * @return this builder instance
         */
        public Builder invocationCallback(
                com.oracle.bmc.util.internal.Consumer<javax.ws.rs.client.Invocation.Builder>
                        invocationCallback) {
            this.invocationCallback = invocationCallback;
            return this;
        }

        /**
         * Set the retry configuration for the request to be built.
         * @param retryConfiguration the retry configuration to be used for the request
         * @return this builder instance
         */
        public Builder retryConfiguration(
                com.oracle.bmc.retrier.RetryConfiguration retryConfiguration) {
            this.retryConfiguration = retryConfiguration;
            return this;
        }

        /**
         * Copy method to populate the builder with values from the given instance.
         * @return this builder instance
         */
        public Builder copy(UpdateSecurityZoneRequest o) {
            securityZoneId(o.getSecurityZoneId());
            updateSecurityZoneDetails(o.getUpdateSecurityZoneDetails());
            ifMatch(o.getIfMatch());
            opcRequestId(o.getOpcRequestId());
            invocationCallback(o.getInvocationCallback());
            retryConfiguration(o.getRetryConfiguration());
            return this;
        }

        /**
         * Build the instance of UpdateSecurityZoneRequest as configured by this builder
         *
         * Note that this method takes calls to {@link Builder#invocationCallback(com.oracle.bmc.util.internal.Consumer)} into account,
         * while the method {@link Builder#buildWithoutInvocationCallback} does not.
         *
         * This is the preferred method to build an instance.
         *
         * @return instance of UpdateSecurityZoneRequest
         */
        public UpdateSecurityZoneRequest build() {
            UpdateSecurityZoneRequest request = buildWithoutInvocationCallback();
            request.setInvocationCallback(invocationCallback);
            request.setRetryConfiguration(retryConfiguration);
            return request;
        }

        /**
         * Alternative setter for the body parameter.
         * @param body the body parameter
         * @return this builder instance
         */
        @com.oracle.bmc.InternalSdk
        public Builder body$(com.oracle.bmc.cloudguard.model.UpdateSecurityZoneDetails body) {
            updateSecurityZoneDetails(body);
            return this;
        }

        /**
         * Build the instance of UpdateSecurityZoneRequest as configured by this builder
         *
         * Note that this method does not take calls to {@link Builder#invocationCallback(com.oracle.bmc.util.internal.Consumer)} into account,
         * while the method {@link Builder#build} does
         *
         * @return instance of UpdateSecurityZoneRequest
         */
        public UpdateSecurityZoneRequest buildWithoutInvocationCallback() {
            UpdateSecurityZoneRequest request = new UpdateSecurityZoneRequest();
            request.securityZoneId = securityZoneId;
            request.updateSecurityZoneDetails = updateSecurityZoneDetails;
            request.ifMatch = ifMatch;
            request.opcRequestId = opcRequestId;
            return request;
            // new UpdateSecurityZoneRequest(securityZoneId, updateSecurityZoneDetails, ifMatch, opcRequestId);
        }
    }

    /**
     * Return an instance of {@link Builder} that allows you to modify request properties.
     * @return instance of {@link Builder} that allows you to modify request properties.
     */
    public Builder toBuilder() {
        return new Builder()
                .securityZoneId(securityZoneId)
                .updateSecurityZoneDetails(updateSecurityZoneDetails)
                .ifMatch(ifMatch)
                .opcRequestId(opcRequestId);
    }

    /**
     * Return a new builder for this request object.
     * @return builder for the request object
     */
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("(");
        sb.append("super=").append(super.toString());
        sb.append(",securityZoneId=").append(String.valueOf(this.securityZoneId));
        sb.append(",updateSecurityZoneDetails=")
                .append(String.valueOf(this.updateSecurityZoneDetails));
        sb.append(",ifMatch=").append(String.valueOf(this.ifMatch));
        sb.append(",opcRequestId=").append(String.valueOf(this.opcRequestId));
        sb.append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UpdateSecurityZoneRequest)) {
            return false;
        }

        UpdateSecurityZoneRequest other = (UpdateSecurityZoneRequest) o;
        return super.equals(o)
                && java.util.Objects.equals(this.securityZoneId, other.securityZoneId)
                && java.util.Objects.equals(
                        this.updateSecurityZoneDetails, other.updateSecurityZoneDetails)
                && java.util.Objects.equals(this.ifMatch, other.ifMatch)
                && java.util.Objects.equals(this.opcRequestId, other.opcRequestId);
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        result =
                (result * PRIME)
                        + (this.securityZoneId == null ? 43 : this.securityZoneId.hashCode());
        result =
                (result * PRIME)
                        + (this.updateSecurityZoneDetails == null
                                ? 43
                                : this.updateSecurityZoneDetails.hashCode());
        result = (result * PRIME) + (this.ifMatch == null ? 43 : this.ifMatch.hashCode());
        result = (result * PRIME) + (this.opcRequestId == null ? 43 : this.opcRequestId.hashCode());
        return result;
    }
}