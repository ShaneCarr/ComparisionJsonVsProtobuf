package com.jersey.groups.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeatureConfiguration {
    @JsonProperty
    public Long id;

    @JsonProperty("feature_id")
    public Long featureId;

    @JsonProperty("feature_name")
    public String featureName;

    @JsonProperty
    public Boolean privacy;

    @JsonProperty("cover_image")
    public String coverImage;

    @JsonProperty("answers_feed_sort")
    public Integer answersFeedSort;

    @JsonProperty("answers_feed_filter")
    public Integer answersFeedFilter;

    @JsonProperty("answers_publisher_topics_src")
    public Integer answersPublisherTopicsSrc;

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
