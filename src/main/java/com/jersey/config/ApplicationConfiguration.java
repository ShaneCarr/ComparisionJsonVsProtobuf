package com.jersey.config;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.client.HttpClientConfiguration;
import io.dropwizard.client.JerseyClientConfiguration;
import io.dropwizard.core.Configuration;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class ApplicationConfiguration extends Configuration {

  @Valid
  @NotNull
  private HttpClientConfiguration httpClient = new HttpClientConfiguration();

  @JsonProperty("httpClient")
  public HttpClientConfiguration getHttpClientConfiguration() {
    return httpClient;
  }

  @JsonProperty("httpClient")
  public void setHttpClientConfiguration(HttpClientConfiguration httpClient) {
    this.httpClient = httpClient;
  }

  @Valid
  @NotNull
  private JerseyClientConfiguration jerseyClient = new JerseyClientConfiguration();

  @JsonProperty("jerseyClient")
  public JerseyClientConfiguration getJerseyClientConfiguration() {
    return jerseyClient;
  }

  @JsonProperty("jerseyClient")
  public void setJerseyClientConfiguration(JerseyClientConfiguration jerseyClient) {
    this.jerseyClient = jerseyClient;
  }


  @Valid
  @NotNull
  @JsonProperty("readWriteDatabase")
  private ReadWriteDatabaseConfiguration readWriteDatabaseConfiguration;


  @Valid
  @JsonProperty("dbpassword")
  public String dbpassword;

  @Valid
  @JsonProperty("dbname")
  public String dbname;

  @Valid
  @JsonProperty("dbuser")
  public String dbuser;

  public ReadWriteDatabaseConfiguration getReadWriteDatabaseConfiguration() {
    return readWriteDatabaseConfiguration;
  }

  public void setReadWriteDatabaseConfiguration(
          ReadWriteDatabaseConfiguration readWriteDatabaseConfiguration) {
    this.readWriteDatabaseConfiguration = readWriteDatabaseConfiguration;
  }

  @Valid
  @NotNull
  @JsonProperty("readOnlyDatabase")
  private ReadOnlyDatabaseConfiguration readOnlyDatabaseConfiguration;

  @JsonProperty("readOnlyDatabase")
  public ReadOnlyDatabaseConfiguration getReadOnlyDatabaseConfiguration() {
    return readOnlyDatabaseConfiguration;
  }

  @JsonProperty("readOnlyDatabase")
  public void setReadOnlyDatabaseConfiguration(ReadOnlyDatabaseConfiguration readOnlyDatabaseConfiguration) {
    this.readOnlyDatabaseConfiguration = readOnlyDatabaseConfiguration;
  }
}
