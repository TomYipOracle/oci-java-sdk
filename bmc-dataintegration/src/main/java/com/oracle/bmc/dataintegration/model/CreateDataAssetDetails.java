/**
 * Copyright (c) 2016, 2022, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.dataintegration.model;

/**
 * Properties used in data asset update operations.
 * <br/>
 * Note: Objects should always be created or deserialized using the {@link Builder}. This model distinguishes fields
 * that are {@code null} because they are unset from fields that are explicitly set to {@code null}. This is done in
 * the setter methods of the {@link Builder}, which maintain a set of all explicitly set fields called
 * {@link #__explicitlySet__}. The {@link #hashCode()} and {@link #equals(Object)} methods are implemented to take
 * {@link #__explicitlySet__} into account. The constructor, on the other hand, does not set {@link #__explicitlySet__}
 * (since the constructor cannot distinguish explicit {@code null} from unset {@code null}).
 **/
@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20200430")
@lombok.AllArgsConstructor(
    onConstructor = @__({@Deprecated}),
    access = lombok.AccessLevel.PROTECTED
)
@lombok.Value
@lombok.experimental.NonFinal
@com.fasterxml.jackson.annotation.JsonTypeInfo(
    use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME,
    include = com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY,
    property = "modelType",
    defaultImpl = CreateDataAssetDetails.class
)
@com.fasterxml.jackson.annotation.JsonSubTypes({
    @com.fasterxml.jackson.annotation.JsonSubTypes.Type(
        value = CreateDataAssetFromJdbc.class,
        name = "GENERIC_JDBC_DATA_ASSET"
    ),
    @com.fasterxml.jackson.annotation.JsonSubTypes.Type(
        value = CreateDataAssetFromMySQL.class,
        name = "MYSQL_DATA_ASSET"
    ),
    @com.fasterxml.jackson.annotation.JsonSubTypes.Type(
        value = CreateDataAssetFromOracle.class,
        name = "ORACLE_DATA_ASSET"
    ),
    @com.fasterxml.jackson.annotation.JsonSubTypes.Type(
        value = CreateDataAssetFromAdwc.class,
        name = "ORACLE_ADWC_DATA_ASSET"
    ),
    @com.fasterxml.jackson.annotation.JsonSubTypes.Type(
        value = CreateDataAssetFromAmazonS3.class,
        name = "AMAZON_S3_DATA_ASSET"
    ),
    @com.fasterxml.jackson.annotation.JsonSubTypes.Type(
        value = CreateDataAssetFromFusionApp.class,
        name = "FUSION_APP_DATA_ASSET"
    ),
    @com.fasterxml.jackson.annotation.JsonSubTypes.Type(
        value = CreateDataAssetFromAtp.class,
        name = "ORACLE_ATP_DATA_ASSET"
    ),
    @com.fasterxml.jackson.annotation.JsonSubTypes.Type(
        value = CreateDataAssetFromObjectStorage.class,
        name = "ORACLE_OBJECT_STORAGE_DATA_ASSET"
    )
})
@com.fasterxml.jackson.annotation.JsonFilter(com.oracle.bmc.http.internal.ExplicitlySetFilter.NAME)
public class CreateDataAssetDetails {

    /**
     * Currently not used on data asset creation. Reserved for future.
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("key")
    String key;

    /**
     * The model version of an object.
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("modelVersion")
    String modelVersion;

    /**
     * Free form text without any restriction on permitted characters. Name can have letters, numbers, and special characters. The value is editable and is restricted to 1000 characters.
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("name")
    String name;

    /**
     * User-defined description of the data asset.
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("description")
    String description;

    /**
     * The status of an object that can be set to value 1 for shallow references across objects, other values reserved.
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("objectStatus")
    Integer objectStatus;

    /**
     * Value can only contain upper case letters, underscore, and numbers. It should begin with upper case letter or underscore. The value can be modified.
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("identifier")
    String identifier;

    /**
     * The external key for the object.
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("externalKey")
    String externalKey;

    /**
     * Additional properties for the data asset.
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("assetProperties")
    java.util.Map<String, String> assetProperties;

    @com.fasterxml.jackson.annotation.JsonProperty("registryMetadata")
    RegistryMetadata registryMetadata;

    /**
     * The type of the data asset.
     **/
    public enum ModelType {
        OracleDataAsset("ORACLE_DATA_ASSET"),
        OracleObjectStorageDataAsset("ORACLE_OBJECT_STORAGE_DATA_ASSET"),
        OracleAtpDataAsset("ORACLE_ATP_DATA_ASSET"),
        OracleAdwcDataAsset("ORACLE_ADWC_DATA_ASSET"),
        MysqlDataAsset("MYSQL_DATA_ASSET"),
        GenericJdbcDataAsset("GENERIC_JDBC_DATA_ASSET"),
        FusionAppDataAsset("FUSION_APP_DATA_ASSET"),
        AmazonS3DataAsset("AMAZON_S3_DATA_ASSET"),
        ;

        private final String value;
        private static java.util.Map<String, ModelType> map;

        static {
            map = new java.util.HashMap<>();
            for (ModelType v : ModelType.values()) {
                map.put(v.getValue(), v);
            }
        }

        ModelType(String value) {
            this.value = value;
        }

        @com.fasterxml.jackson.annotation.JsonValue
        public String getValue() {
            return value;
        }

        @com.fasterxml.jackson.annotation.JsonCreator
        public static ModelType create(String key) {
            if (map.containsKey(key)) {
                return map.get(key);
            }
            throw new IllegalArgumentException("Invalid ModelType: " + key);
        }
    };
}
