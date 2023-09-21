package com.jersey.groups.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feature {
    @JsonProperty
    public Long id;

    @JsonProperty("group_id")
    public Long groupId;

    @JsonProperty("feature_name")
    public String featureName;

    @JsonProperty("feature_type")
    public Integer featureType;

    @JsonProperty("created_at")
    public Long createdAt;

    @JsonProperty("created_by")
    public Long createdBy;

    @JsonProperty("modified_at")
    public Long modifiedAt;

    @JsonProperty("modified_by")
    public Long modifiedBy;

    // Constructors, getters, and setters
}
