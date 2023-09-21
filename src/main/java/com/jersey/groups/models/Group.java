package com.jersey.groups.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Group {
    @JsonProperty
    public Long id;

    @JsonProperty
    public String name;

    @JsonProperty("office_id")
    public Long officeId;

}
