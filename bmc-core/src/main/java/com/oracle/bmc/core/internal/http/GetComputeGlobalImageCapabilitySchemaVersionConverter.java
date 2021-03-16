/**
 * Copyright (c) 2016, 2021, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.core.internal.http;

import com.oracle.bmc.http.internal.ResponseHelper;
import com.oracle.bmc.core.model.*;
import com.oracle.bmc.core.requests.*;
import com.oracle.bmc.core.responses.*;
import org.apache.commons.lang3.Validate;

@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20160918")
@lombok.extern.slf4j.Slf4j
public class GetComputeGlobalImageCapabilitySchemaVersionConverter {
    private static final com.oracle.bmc.http.internal.ResponseConversionFunctionFactory
            RESPONSE_CONVERSION_FACTORY =
                    new com.oracle.bmc.http.internal.ResponseConversionFunctionFactory();

    public static com.oracle.bmc.core.requests.GetComputeGlobalImageCapabilitySchemaVersionRequest
            interceptRequest(
                    com.oracle.bmc.core.requests.GetComputeGlobalImageCapabilitySchemaVersionRequest
                            request) {

        return request;
    }

    public static com.oracle.bmc.http.internal.WrappedInvocationBuilder fromRequest(
            com.oracle.bmc.http.internal.RestClient client,
            com.oracle.bmc.core.requests.GetComputeGlobalImageCapabilitySchemaVersionRequest
                    request) {
        Validate.notNull(request, "request instance is required");
        Validate.notBlank(
                request.getComputeGlobalImageCapabilitySchemaId(),
                "computeGlobalImageCapabilitySchemaId must not be blank");
        Validate.notBlank(
                request.getComputeGlobalImageCapabilitySchemaVersionName(),
                "computeGlobalImageCapabilitySchemaVersionName must not be blank");

        com.oracle.bmc.http.internal.WrappedWebTarget target =
                client.getBaseTarget()
                        .path("/20160918")
                        .path("computeGlobalImageCapabilitySchemas")
                        .path(
                                com.oracle.bmc.util.internal.HttpUtils.encodePathSegment(
                                        request.getComputeGlobalImageCapabilitySchemaId()))
                        .path("versions")
                        .path(
                                com.oracle.bmc.util.internal.HttpUtils.encodePathSegment(
                                        request
                                                .getComputeGlobalImageCapabilitySchemaVersionName()));

        com.oracle.bmc.http.internal.WrappedInvocationBuilder ib = target.request();

        ib.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON);

        return ib;
    }

    public static com.google.common.base.Function<
                    javax.ws.rs.core.Response,
                    com.oracle.bmc.core.responses
                            .GetComputeGlobalImageCapabilitySchemaVersionResponse>
            fromResponse() {
        final com.google.common.base.Function<
                        javax.ws.rs.core.Response,
                        com.oracle.bmc.core.responses
                                .GetComputeGlobalImageCapabilitySchemaVersionResponse>
                transformer =
                        new com.google.common.base.Function<
                                javax.ws.rs.core.Response,
                                com.oracle.bmc.core.responses
                                        .GetComputeGlobalImageCapabilitySchemaVersionResponse>() {
                            @Override
                            public com.oracle.bmc.core.responses
                                            .GetComputeGlobalImageCapabilitySchemaVersionResponse
                                    apply(javax.ws.rs.core.Response rawResponse) {
                                LOG.trace(
                                        "Transform function invoked for com.oracle.bmc.core.responses.GetComputeGlobalImageCapabilitySchemaVersionResponse");
                                com.google.common.base.Function<
                                                javax.ws.rs.core.Response,
                                                com.oracle.bmc.http.internal.WithHeaders<
                                                        ComputeGlobalImageCapabilitySchemaVersion>>
                                        responseFn =
                                                RESPONSE_CONVERSION_FACTORY.create(
                                                        ComputeGlobalImageCapabilitySchemaVersion
                                                                .class);

                                com.oracle.bmc.http.internal.WithHeaders<
                                                ComputeGlobalImageCapabilitySchemaVersion>
                                        response = responseFn.apply(rawResponse);
                                javax.ws.rs.core.MultivaluedMap<String, String> headers =
                                        response.getHeaders();

                                com.oracle.bmc.core.responses
                                                .GetComputeGlobalImageCapabilitySchemaVersionResponse
                                                .Builder
                                        builder =
                                                com.oracle.bmc.core.responses
                                                        .GetComputeGlobalImageCapabilitySchemaVersionResponse
                                                        .builder()
                                                        .__httpStatusCode__(
                                                                rawResponse.getStatus());

                                builder.computeGlobalImageCapabilitySchemaVersion(
                                        response.getItem());

                                com.google.common.base.Optional<java.util.List<String>> etagHeader =
                                        com.oracle.bmc.http.internal.HeaderUtils.get(
                                                headers, "etag");
                                if (etagHeader.isPresent()) {
                                    builder.etag(
                                            com.oracle.bmc.http.internal.HeaderUtils.toValue(
                                                    "etag", etagHeader.get().get(0), String.class));
                                }

                                com.google.common.base.Optional<java.util.List<String>>
                                        opcRequestIdHeader =
                                                com.oracle.bmc.http.internal.HeaderUtils.get(
                                                        headers, "opc-request-id");
                                if (opcRequestIdHeader.isPresent()) {
                                    builder.opcRequestId(
                                            com.oracle.bmc.http.internal.HeaderUtils.toValue(
                                                    "opc-request-id",
                                                    opcRequestIdHeader.get().get(0),
                                                    String.class));
                                }

                                com.oracle.bmc.core.responses
                                                .GetComputeGlobalImageCapabilitySchemaVersionResponse
                                        responseWrapper = builder.build();

                                ResponseHelper.closeResponseSilentlyIfNotBuffered(rawResponse);
                                return responseWrapper;
                            }
                        };
        return transformer;
    }
}