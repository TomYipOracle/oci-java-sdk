/**
 * Copyright (c) 2016, 2023, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.oda.requests;

import com.oracle.bmc.oda.model.*;
/**
 * <b>Example: </b>Click <a
 * href="https://docs.cloud.oracle.com/en-us/iaas/tools/java-sdk-examples/latest/oda/GetOdaPrivateEndpointScanProxyExample.java.html"
 * target="_blank" rel="noopener noreferrer">here</a> to see how to use
 * GetOdaPrivateEndpointScanProxyRequest.
 */
@jakarta.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20190506")
public class GetOdaPrivateEndpointScanProxyRequest
        extends com.oracle.bmc.requests.BmcRequest<java.lang.Void> {

    /** Unique ODA Private Endpoint Scan Proxy identifier. */
    private String odaPrivateEndpointScanProxyId;

    /** Unique ODA Private Endpoint Scan Proxy identifier. */
    public String getOdaPrivateEndpointScanProxyId() {
        return odaPrivateEndpointScanProxyId;
    }
    /**
     * Unique ODA Private Endpoint identifier which is the
     * [OCID](https://docs.cloud.oracle.com/iaas/Content/General/Concepts/identifiers.htm).
     */
    private String odaPrivateEndpointId;

    /**
     * Unique ODA Private Endpoint identifier which is the
     * [OCID](https://docs.cloud.oracle.com/iaas/Content/General/Concepts/identifiers.htm).
     */
    public String getOdaPrivateEndpointId() {
        return odaPrivateEndpointId;
    }
    /**
     * The client request ID for tracing. This value is included in the opc-request-id response
     * header.
     */
    private String opcRequestId;

    /**
     * The client request ID for tracing. This value is included in the opc-request-id response
     * header.
     */
    public String getOpcRequestId() {
        return opcRequestId;
    }

    public static class Builder
            implements com.oracle.bmc.requests.BmcRequest.Builder<
                    GetOdaPrivateEndpointScanProxyRequest, java.lang.Void> {
        private com.oracle.bmc.http.client.RequestInterceptor invocationCallback = null;
        private com.oracle.bmc.retrier.RetryConfiguration retryConfiguration = null;

        /** Unique ODA Private Endpoint Scan Proxy identifier. */
        private String odaPrivateEndpointScanProxyId = null;

        /**
         * Unique ODA Private Endpoint Scan Proxy identifier.
         *
         * @param odaPrivateEndpointScanProxyId the value to set
         * @return this builder instance
         */
        public Builder odaPrivateEndpointScanProxyId(String odaPrivateEndpointScanProxyId) {
            this.odaPrivateEndpointScanProxyId = odaPrivateEndpointScanProxyId;
            return this;
        }

        /**
         * Unique ODA Private Endpoint identifier which is the
         * [OCID](https://docs.cloud.oracle.com/iaas/Content/General/Concepts/identifiers.htm).
         */
        private String odaPrivateEndpointId = null;

        /**
         * Unique ODA Private Endpoint identifier which is the
         * [OCID](https://docs.cloud.oracle.com/iaas/Content/General/Concepts/identifiers.htm).
         *
         * @param odaPrivateEndpointId the value to set
         * @return this builder instance
         */
        public Builder odaPrivateEndpointId(String odaPrivateEndpointId) {
            this.odaPrivateEndpointId = odaPrivateEndpointId;
            return this;
        }

        /**
         * The client request ID for tracing. This value is included in the opc-request-id response
         * header.
         */
        private String opcRequestId = null;

        /**
         * The client request ID for tracing. This value is included in the opc-request-id response
         * header.
         *
         * @param opcRequestId the value to set
         * @return this builder instance
         */
        public Builder opcRequestId(String opcRequestId) {
            this.opcRequestId = opcRequestId;
            return this;
        }

        /**
         * Set the invocation callback for the request to be built.
         *
         * @param invocationCallback the invocation callback to be set for the request
         * @return this builder instance
         */
        public Builder invocationCallback(
                com.oracle.bmc.http.client.RequestInterceptor invocationCallback) {
            this.invocationCallback = invocationCallback;
            return this;
        }

        /**
         * Set the retry configuration for the request to be built.
         *
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
         *
         * @return this builder instance
         */
        public Builder copy(GetOdaPrivateEndpointScanProxyRequest o) {
            odaPrivateEndpointScanProxyId(o.getOdaPrivateEndpointScanProxyId());
            odaPrivateEndpointId(o.getOdaPrivateEndpointId());
            opcRequestId(o.getOpcRequestId());
            invocationCallback(o.getInvocationCallback());
            retryConfiguration(o.getRetryConfiguration());
            return this;
        }

        /**
         * Build the instance of GetOdaPrivateEndpointScanProxyRequest as configured by this builder
         *
         * <p>Note that this method takes calls to {@link
         * Builder#invocationCallback(com.oracle.bmc.http.client.RequestInterceptor)} into account,
         * while the method {@link Builder#buildWithoutInvocationCallback} does not.
         *
         * <p>This is the preferred method to build an instance.
         *
         * @return instance of GetOdaPrivateEndpointScanProxyRequest
         */
        public GetOdaPrivateEndpointScanProxyRequest build() {
            GetOdaPrivateEndpointScanProxyRequest request = buildWithoutInvocationCallback();
            request.setInvocationCallback(invocationCallback);
            request.setRetryConfiguration(retryConfiguration);
            return request;
        }

        /**
         * Build the instance of GetOdaPrivateEndpointScanProxyRequest as configured by this builder
         *
         * <p>Note that this method does not take calls to {@link
         * Builder#invocationCallback(com.oracle.bmc.http.client.RequestInterceptor)} into account,
         * while the method {@link Builder#build} does
         *
         * @return instance of GetOdaPrivateEndpointScanProxyRequest
         */
        public GetOdaPrivateEndpointScanProxyRequest buildWithoutInvocationCallback() {
            GetOdaPrivateEndpointScanProxyRequest request =
                    new GetOdaPrivateEndpointScanProxyRequest();
            request.odaPrivateEndpointScanProxyId = odaPrivateEndpointScanProxyId;
            request.odaPrivateEndpointId = odaPrivateEndpointId;
            request.opcRequestId = opcRequestId;
            return request;
            // new GetOdaPrivateEndpointScanProxyRequest(odaPrivateEndpointScanProxyId,
            // odaPrivateEndpointId, opcRequestId);
        }
    }

    /**
     * Return an instance of {@link Builder} that allows you to modify request properties.
     *
     * @return instance of {@link Builder} that allows you to modify request properties.
     */
    public Builder toBuilder() {
        return new Builder()
                .odaPrivateEndpointScanProxyId(odaPrivateEndpointScanProxyId)
                .odaPrivateEndpointId(odaPrivateEndpointId)
                .opcRequestId(opcRequestId);
    }

    /**
     * Return a new builder for this request object.
     *
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
        sb.append(",odaPrivateEndpointScanProxyId=")
                .append(String.valueOf(this.odaPrivateEndpointScanProxyId));
        sb.append(",odaPrivateEndpointId=").append(String.valueOf(this.odaPrivateEndpointId));
        sb.append(",opcRequestId=").append(String.valueOf(this.opcRequestId));
        sb.append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetOdaPrivateEndpointScanProxyRequest)) {
            return false;
        }

        GetOdaPrivateEndpointScanProxyRequest other = (GetOdaPrivateEndpointScanProxyRequest) o;
        return super.equals(o)
                && java.util.Objects.equals(
                        this.odaPrivateEndpointScanProxyId, other.odaPrivateEndpointScanProxyId)
                && java.util.Objects.equals(this.odaPrivateEndpointId, other.odaPrivateEndpointId)
                && java.util.Objects.equals(this.opcRequestId, other.opcRequestId);
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        result =
                (result * PRIME)
                        + (this.odaPrivateEndpointScanProxyId == null
                                ? 43
                                : this.odaPrivateEndpointScanProxyId.hashCode());
        result =
                (result * PRIME)
                        + (this.odaPrivateEndpointId == null
                                ? 43
                                : this.odaPrivateEndpointId.hashCode());
        result = (result * PRIME) + (this.opcRequestId == null ? 43 : this.opcRequestId.hashCode());
        return result;
    }
}
