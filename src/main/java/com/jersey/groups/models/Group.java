package com.jersey.groups.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Group {
    @JsonProperty
    public Long id;

    @JsonProperty("name")
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("officeId")
    public Long officeId;

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

}
