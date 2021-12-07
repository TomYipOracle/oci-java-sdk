/**
 * Copyright (c) 2016, 2021, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.dataintegration.model;

/**
 * Frequency Details model for weekly frequency based on day of week.
 * <br/>
 * Note: Objects should always be created or deserialized using the {@link Builder}. This model distinguishes fields
 * that are {@code null} because they are unset from fields that are explicitly set to {@code null}. This is done in
 * the setter methods of the {@link Builder}, which maintain a set of all explicitly set fields called
 * {@link #__explicitlySet__}. The {@link #hashCode()} and {@link #equals(Object)} methods are implemented to take
 * {@link #__explicitlySet__} into account. The constructor, on the other hand, does not set {@link #__explicitlySet__}
 * (since the constructor cannot distinguish explicit {@code null} from unset {@code null}).
 **/
@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20200430")
@lombok.Value
@com.fasterxml.jackson.databind.annotation.JsonDeserialize(
    builder = WeeklyFrequencyDetails.Builder.class
)
@lombok.ToString(callSuper = true)
@lombok.EqualsAndHashCode(callSuper = true)
@com.fasterxml.jackson.annotation.JsonTypeInfo(
    use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME,
    include = com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY,
    property = "modelType"
)
@com.fasterxml.jackson.annotation.JsonFilter(com.oracle.bmc.http.internal.ExplicitlySetFilter.NAME)
@lombok.Builder(builderClassName = "Builder", toBuilder = true)
public class WeeklyFrequencyDetails extends AbstractFrequencyDetails {
    @com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder(withPrefix = "")
    @lombok.experimental.Accessors(fluent = true)
    public static class Builder {
        @com.fasterxml.jackson.annotation.JsonProperty("frequency")
        private Frequency frequency;

        public Builder frequency(Frequency frequency) {
            this.frequency = frequency;
            this.__explicitlySet__.add("frequency");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("time")
        private Time time;

        public Builder time(Time time) {
            this.time = time;
            this.__explicitlySet__.add("time");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("days")
        private java.util.List<Days> days;

        public Builder days(java.util.List<Days> days) {
            this.days = days;
            this.__explicitlySet__.add("days");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonIgnore
        private final java.util.Set<String> __explicitlySet__ = new java.util.HashSet<String>();

        public WeeklyFrequencyDetails build() {
            WeeklyFrequencyDetails __instance__ = new WeeklyFrequencyDetails(frequency, time, days);
            __instance__.__explicitlySet__.addAll(__explicitlySet__);
            return __instance__;
        }

        @com.fasterxml.jackson.annotation.JsonIgnore
        public Builder copy(WeeklyFrequencyDetails o) {
            Builder copiedBuilder = frequency(o.getFrequency()).time(o.getTime()).days(o.getDays());

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

    @Deprecated
    public WeeklyFrequencyDetails(Frequency frequency, Time time, java.util.List<Days> days) {
        super(frequency);
        this.time = time;
        this.days = days;
    }

    @com.fasterxml.jackson.annotation.JsonProperty("time")
    Time time;
    /**
     **/
    @lombok.extern.slf4j.Slf4j
    public enum Days {
        Sunday("SUNDAY"),
        Monday("MONDAY"),
        Tuesday("TUESDAY"),
        Wednesday("WEDNESDAY"),
        Thursday("THURSDAY"),
        Friday("FRIDAY"),
        Saturday("SATURDAY"),

        /**
         * This value is used if a service returns a value for this enum that is not recognized by this
         * version of the SDK.
         */
        UnknownEnumValue(null);

        private final String value;
        private static java.util.Map<String, Days> map;

        static {
            map = new java.util.HashMap<>();
            for (Days v : Days.values()) {
                if (v != UnknownEnumValue) {
                    map.put(v.getValue(), v);
                }
            }
        }

        Days(String value) {
            this.value = value;
        }

        @com.fasterxml.jackson.annotation.JsonValue
        public String getValue() {
            return value;
        }

        @com.fasterxml.jackson.annotation.JsonCreator
        public static Days create(String key) {
            if (map.containsKey(key)) {
                return map.get(key);
            }
            LOG.warn(
                    "Received unknown value '{}' for enum 'Days', returning UnknownEnumValue", key);
            return UnknownEnumValue;
        }
    };
    /**
     * A list of days of the week to be scheduled. i.e. execute on Monday and Thursday.
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("days")
    java.util.List<Days> days;

    @com.fasterxml.jackson.annotation.JsonIgnore
    private final java.util.Set<String> __explicitlySet__ = new java.util.HashSet<String>();
}