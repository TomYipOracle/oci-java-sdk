/**
 * Copyright (c) 2016, 2022, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.jms.model;

/**
 * Details of the request to start a JFR analysis. When the targets aren't specified, then all
 * managed instances currently in the fleet are selected. <br>
 * Note: Objects should always be created or deserialized using the {@link Builder}. This model
 * distinguishes fields that are {@code null} because they are unset from fields that are explicitly
 * set to {@code null}. This is done in the setter methods of the {@link Builder}, which maintain a
 * set of all explicitly set fields called {@link #__explicitlySet__}. The {@link #hashCode()} and
 * {@link #equals(Object)} methods are implemented to take {@link #__explicitlySet__} into account.
 * The constructor, on the other hand, does not set {@link #__explicitlySet__} (since the
 * constructor cannot distinguish explicit {@code null} from unset {@code null}).
 */
@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20210610")
@com.fasterxml.jackson.databind.annotation.JsonDeserialize(
        builder = RequestCryptoAnalysesDetails.Builder.class)
@com.fasterxml.jackson.annotation.JsonFilter(
        com.oracle.bmc.http.client.internal.ExplicitlySetFilter.NAME)
public final class RequestCryptoAnalysesDetails
        extends com.oracle.bmc.http.client.internal.ExplicitlySetBmcModel {
    @Deprecated
    @java.beans.ConstructorProperties({"targets", "recordingDurationInMinutes"})
    public RequestCryptoAnalysesDetails(
            java.util.List<JfrAttachmentTarget> targets, Integer recordingDurationInMinutes) {
        super();
        this.targets = targets;
        this.recordingDurationInMinutes = recordingDurationInMinutes;
    }

    @com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        /** The attachment targets to start JFR. */
        @com.fasterxml.jackson.annotation.JsonProperty("targets")
        private java.util.List<JfrAttachmentTarget> targets;

        /**
         * The attachment targets to start JFR.
         *
         * @param targets the value to set
         * @return this builder
         */
        public Builder targets(java.util.List<JfrAttachmentTarget> targets) {
            this.targets = targets;
            this.__explicitlySet__.add("targets");
            return this;
        }
        /** Duration of the JFR recording in minutes. */
        @com.fasterxml.jackson.annotation.JsonProperty("recordingDurationInMinutes")
        private Integer recordingDurationInMinutes;

        /**
         * Duration of the JFR recording in minutes.
         *
         * @param recordingDurationInMinutes the value to set
         * @return this builder
         */
        public Builder recordingDurationInMinutes(Integer recordingDurationInMinutes) {
            this.recordingDurationInMinutes = recordingDurationInMinutes;
            this.__explicitlySet__.add("recordingDurationInMinutes");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonIgnore
        private final java.util.Set<String> __explicitlySet__ = new java.util.HashSet<String>();

        public RequestCryptoAnalysesDetails build() {
            RequestCryptoAnalysesDetails model =
                    new RequestCryptoAnalysesDetails(this.targets, this.recordingDurationInMinutes);
            for (String explicitlySetProperty : this.__explicitlySet__) {
                model.markPropertyAsExplicitlySet(explicitlySetProperty);
            }
            return model;
        }

        @com.fasterxml.jackson.annotation.JsonIgnore
        public Builder copy(RequestCryptoAnalysesDetails model) {
            if (model.wasPropertyExplicitlySet("targets")) {
                this.targets(model.getTargets());
            }
            if (model.wasPropertyExplicitlySet("recordingDurationInMinutes")) {
                this.recordingDurationInMinutes(model.getRecordingDurationInMinutes());
            }
            return this;
        }
    }

    /** Create a new builder. */
    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return new Builder().copy(this);
    }

    /** The attachment targets to start JFR. */
    @com.fasterxml.jackson.annotation.JsonProperty("targets")
    private final java.util.List<JfrAttachmentTarget> targets;

    /**
     * The attachment targets to start JFR.
     *
     * @return the value
     */
    public java.util.List<JfrAttachmentTarget> getTargets() {
        return targets;
    }

    /** Duration of the JFR recording in minutes. */
    @com.fasterxml.jackson.annotation.JsonProperty("recordingDurationInMinutes")
    private final Integer recordingDurationInMinutes;

    /**
     * Duration of the JFR recording in minutes.
     *
     * @return the value
     */
    public Integer getRecordingDurationInMinutes() {
        return recordingDurationInMinutes;
    }

    @Override
    public String toString() {
        return this.toString(true);
    }

    /**
     * Return a string representation of the object.
     *
     * @param includeByteArrayContents true to include the full contents of byte arrays
     * @return string representation
     */
    public String toString(boolean includeByteArrayContents) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("RequestCryptoAnalysesDetails(");
        sb.append("super=").append(super.toString());
        sb.append("targets=").append(String.valueOf(this.targets));
        sb.append(", recordingDurationInMinutes=")
                .append(String.valueOf(this.recordingDurationInMinutes));
        sb.append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RequestCryptoAnalysesDetails)) {
            return false;
        }

        RequestCryptoAnalysesDetails other = (RequestCryptoAnalysesDetails) o;
        return java.util.Objects.equals(this.targets, other.targets)
                && java.util.Objects.equals(
                        this.recordingDurationInMinutes, other.recordingDurationInMinutes)
                && super.equals(other);
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = (result * PRIME) + (this.targets == null ? 43 : this.targets.hashCode());
        result =
                (result * PRIME)
                        + (this.recordingDurationInMinutes == null
                                ? 43
                                : this.recordingDurationInMinutes.hashCode());
        result = (result * PRIME) + super.hashCode();
        return result;
    }
}