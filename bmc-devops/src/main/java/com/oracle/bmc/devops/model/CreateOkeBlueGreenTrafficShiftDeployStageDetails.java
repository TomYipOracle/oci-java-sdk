/**
 * Copyright (c) 2016, 2022, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.devops.model;

/**
 * Specifies the Container Engine for Kubernetes (OKE) cluster blue-green deployment traffic shift stage.
 * <br/>
 * Note: Objects should always be created or deserialized using the {@link Builder}. This model distinguishes fields
 * that are {@code null} because they are unset from fields that are explicitly set to {@code null}. This is done in
 * the setter methods of the {@link Builder}, which maintain a set of all explicitly set fields called
 * {@link #__explicitlySet__}. The {@link #hashCode()} and {@link #equals(Object)} methods are implemented to take
 * {@link #__explicitlySet__} into account. The constructor, on the other hand, does not set {@link #__explicitlySet__}
 * (since the constructor cannot distinguish explicit {@code null} from unset {@code null}).
 **/
@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20210630")
@com.fasterxml.jackson.databind.annotation.JsonDeserialize(
    builder = CreateOkeBlueGreenTrafficShiftDeployStageDetails.Builder.class
)
@com.fasterxml.jackson.annotation.JsonTypeInfo(
    use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME,
    include = com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY,
    property = "deployStageType"
)
@com.fasterxml.jackson.annotation.JsonFilter(com.oracle.bmc.http.internal.ExplicitlySetFilter.NAME)
public final class CreateOkeBlueGreenTrafficShiftDeployStageDetails
        extends CreateDeployStageDetails {
    @com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        @com.fasterxml.jackson.annotation.JsonProperty("description")
        private String description;

        public Builder description(String description) {
            this.description = description;
            this.__explicitlySet__.add("description");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("displayName")
        private String displayName;

        public Builder displayName(String displayName) {
            this.displayName = displayName;
            this.__explicitlySet__.add("displayName");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("deployPipelineId")
        private String deployPipelineId;

        public Builder deployPipelineId(String deployPipelineId) {
            this.deployPipelineId = deployPipelineId;
            this.__explicitlySet__.add("deployPipelineId");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("deployStagePredecessorCollection")
        private DeployStagePredecessorCollection deployStagePredecessorCollection;

        public Builder deployStagePredecessorCollection(
                DeployStagePredecessorCollection deployStagePredecessorCollection) {
            this.deployStagePredecessorCollection = deployStagePredecessorCollection;
            this.__explicitlySet__.add("deployStagePredecessorCollection");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("freeformTags")
        private java.util.Map<String, String> freeformTags;

        public Builder freeformTags(java.util.Map<String, String> freeformTags) {
            this.freeformTags = freeformTags;
            this.__explicitlySet__.add("freeformTags");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("definedTags")
        private java.util.Map<String, java.util.Map<String, Object>> definedTags;

        public Builder definedTags(
                java.util.Map<String, java.util.Map<String, Object>> definedTags) {
            this.definedTags = definedTags;
            this.__explicitlySet__.add("definedTags");
            return this;
        }
        /**
         * The OCID of the upstream OKE blue-green deployment stage in this pipeline.
         **/
        @com.fasterxml.jackson.annotation.JsonProperty("okeBlueGreenDeployStageId")
        private String okeBlueGreenDeployStageId;

        /**
         * The OCID of the upstream OKE blue-green deployment stage in this pipeline.
         * @param okeBlueGreenDeployStageId the value to set
         * @return this builder
         **/
        public Builder okeBlueGreenDeployStageId(String okeBlueGreenDeployStageId) {
            this.okeBlueGreenDeployStageId = okeBlueGreenDeployStageId;
            this.__explicitlySet__.add("okeBlueGreenDeployStageId");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonIgnore
        private final java.util.Set<String> __explicitlySet__ = new java.util.HashSet<String>();

        public CreateOkeBlueGreenTrafficShiftDeployStageDetails build() {
            CreateOkeBlueGreenTrafficShiftDeployStageDetails __instance__ =
                    new CreateOkeBlueGreenTrafficShiftDeployStageDetails(
                            description,
                            displayName,
                            deployPipelineId,
                            deployStagePredecessorCollection,
                            freeformTags,
                            definedTags,
                            okeBlueGreenDeployStageId);
            __instance__.__explicitlySet__.addAll(__explicitlySet__);
            return __instance__;
        }

        @com.fasterxml.jackson.annotation.JsonIgnore
        public Builder copy(CreateOkeBlueGreenTrafficShiftDeployStageDetails o) {
            Builder copiedBuilder =
                    description(o.getDescription())
                            .displayName(o.getDisplayName())
                            .deployPipelineId(o.getDeployPipelineId())
                            .deployStagePredecessorCollection(
                                    o.getDeployStagePredecessorCollection())
                            .freeformTags(o.getFreeformTags())
                            .definedTags(o.getDefinedTags())
                            .okeBlueGreenDeployStageId(o.getOkeBlueGreenDeployStageId());

            copiedBuilder.__explicitlySet__.retainAll(o.__explicitlySet__);
            return copiedBuilder;
        }
    }

    /**
     * Create a new builder.
     */
    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return new Builder().copy(this);
    }

    @Deprecated
    public CreateOkeBlueGreenTrafficShiftDeployStageDetails(
            String description,
            String displayName,
            String deployPipelineId,
            DeployStagePredecessorCollection deployStagePredecessorCollection,
            java.util.Map<String, String> freeformTags,
            java.util.Map<String, java.util.Map<String, Object>> definedTags,
            String okeBlueGreenDeployStageId) {
        super(
                description,
                displayName,
                deployPipelineId,
                deployStagePredecessorCollection,
                freeformTags,
                definedTags);
        this.okeBlueGreenDeployStageId = okeBlueGreenDeployStageId;
    }

    /**
     * The OCID of the upstream OKE blue-green deployment stage in this pipeline.
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("okeBlueGreenDeployStageId")
    private final String okeBlueGreenDeployStageId;

    /**
     * The OCID of the upstream OKE blue-green deployment stage in this pipeline.
     * @return the value
     **/
    public String getOkeBlueGreenDeployStageId() {
        return okeBlueGreenDeployStageId;
    }

    @Override
    public String toString() {
        return this.toString(true);
    }

    /**
     * Return a string representation of the object.
     * @param includeByteArrayContents true to include the full contents of byte arrays
     * @return string representation
     */
    public String toString(boolean includeByteArrayContents) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("CreateOkeBlueGreenTrafficShiftDeployStageDetails(");
        sb.append("super=").append(super.toString(includeByteArrayContents));
        sb.append(", okeBlueGreenDeployStageId=")
                .append(String.valueOf(this.okeBlueGreenDeployStageId));
        sb.append("__explicitlySet__=").append(String.valueOf(this.__explicitlySet__));
        sb.append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CreateOkeBlueGreenTrafficShiftDeployStageDetails)) {
            return false;
        }

        CreateOkeBlueGreenTrafficShiftDeployStageDetails other =
                (CreateOkeBlueGreenTrafficShiftDeployStageDetails) o;
        return java.util.Objects.equals(
                        this.okeBlueGreenDeployStageId, other.okeBlueGreenDeployStageId)
                && java.util.Objects.equals(this.__explicitlySet__, other.__explicitlySet__)
                && super.equals(o);
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        result =
                (result * PRIME)
                        + (this.okeBlueGreenDeployStageId == null
                                ? 43
                                : this.okeBlueGreenDeployStageId.hashCode());
        result =
                (result * PRIME)
                        + (this.__explicitlySet__ == null ? 43 : this.__explicitlySet__.hashCode());
        return result;
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    private final java.util.Set<String> __explicitlySet__ = new java.util.HashSet<String>();

    public java.util.Set<String> get__explicitlySet__() {
        return this.__explicitlySet__;
    }
}