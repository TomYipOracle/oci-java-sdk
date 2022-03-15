/**
 * Copyright (c) 2016, 2022, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.datasafe.model;

/**
 * Represents audit policies with corresponding audit provisioning conditions.
 * <br/>
 * Note: Objects should always be created or deserialized using the {@link Builder}. This model distinguishes fields
 * that are {@code null} because they are unset from fields that are explicitly set to {@code null}. This is done in
 * the setter methods of the {@link Builder}, which maintain a set of all explicitly set fields called
 * {@link #__explicitlySet__}. The {@link #hashCode()} and {@link #equals(Object)} methods are implemented to take
 * {@link #__explicitlySet__} into account. The constructor, on the other hand, does not set {@link #__explicitlySet__}
 * (since the constructor cannot distinguish explicit {@code null} from unset {@code null}).
 **/
@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20181201")
@lombok.AllArgsConstructor(onConstructor = @__({@Deprecated}))
@lombok.Value
@com.fasterxml.jackson.databind.annotation.JsonDeserialize(
    builder = ProvisionAuditConditions.Builder.class
)
@com.fasterxml.jackson.annotation.JsonFilter(com.oracle.bmc.http.internal.ExplicitlySetFilter.NAME)
@lombok.Builder(builderClassName = "Builder", toBuilder = true)
public class ProvisionAuditConditions {
    @com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder(withPrefix = "")
    @lombok.experimental.Accessors(fluent = true)
    public static class Builder {
        @com.fasterxml.jackson.annotation.JsonProperty("auditPolicyName")
        private String auditPolicyName;

        public Builder auditPolicyName(String auditPolicyName) {
            this.auditPolicyName = auditPolicyName;
            this.__explicitlySet__.add("auditPolicyName");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("isPrivUsersManagedByDataSafe")
        private Boolean isPrivUsersManagedByDataSafe;

        public Builder isPrivUsersManagedByDataSafe(Boolean isPrivUsersManagedByDataSafe) {
            this.isPrivUsersManagedByDataSafe = isPrivUsersManagedByDataSafe;
            this.__explicitlySet__.add("isPrivUsersManagedByDataSafe");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("isEnabled")
        private Boolean isEnabled;

        public Builder isEnabled(Boolean isEnabled) {
            this.isEnabled = isEnabled;
            this.__explicitlySet__.add("isEnabled");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("enableConditions")
        private java.util.List<EnableConditions> enableConditions;

        public Builder enableConditions(java.util.List<EnableConditions> enableConditions) {
            this.enableConditions = enableConditions;
            this.__explicitlySet__.add("enableConditions");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonIgnore
        private final java.util.Set<String> __explicitlySet__ = new java.util.HashSet<String>();

        public ProvisionAuditConditions build() {
            ProvisionAuditConditions __instance__ =
                    new ProvisionAuditConditions(
                            auditPolicyName,
                            isPrivUsersManagedByDataSafe,
                            isEnabled,
                            enableConditions);
            __instance__.__explicitlySet__.addAll(__explicitlySet__);
            return __instance__;
        }

        @com.fasterxml.jackson.annotation.JsonIgnore
        public Builder copy(ProvisionAuditConditions o) {
            Builder copiedBuilder =
                    auditPolicyName(o.getAuditPolicyName())
                            .isPrivUsersManagedByDataSafe(o.getIsPrivUsersManagedByDataSafe())
                            .isEnabled(o.getIsEnabled())
                            .enableConditions(o.getEnableConditions());

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

    /**
     * Indicates the audit policy name available for provisioning from Data Safe. Refer to the [documentation](https://docs.oracle.com/en/cloud/paas/data-safe/udscs/audit-policies.html#GUID-361A9A9A-7C21-4F5A-8945-9B3A0C472827) for seeded audit policy names. For custom policies, refer to the user-defined policy name created in the target database.
     *
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("auditPolicyName")
    String auditPolicyName;

    /**
     * Indicates whether the privileged user list is managed by Data Safe.
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("isPrivUsersManagedByDataSafe")
    Boolean isPrivUsersManagedByDataSafe;

    /**
     * Indicates whether the policy has to be enabled or disabled in the target database. Set this to true if you want the audit policy to be enabled in the target database. If the seeded audit policy is not already created in the database, the provisioning creates and enables them. If this is set to false, the policy will be disabled in the target database.
     *
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("isEnabled")
    Boolean isEnabled;

    /**
     * Indicates the users/roles in the target database for which the audit policy will be enforced, and the success/failure event condition to generate the audit event.
     *
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("enableConditions")
    java.util.List<EnableConditions> enableConditions;

    @com.fasterxml.jackson.annotation.JsonIgnore
    private final java.util.Set<String> __explicitlySet__ = new java.util.HashSet<String>();
}