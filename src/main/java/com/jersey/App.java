package com.jersey;

import com.jersey.auth.AppAuthorizer;
import com.jersey.auth.AppBasicAuthenticator;
import com.jersey.auth.User;
import com.jersey.config.ApplicationConfiguration;
import com.jersey.config.ReadWriteDatabaseConfiguration;
import com.jersey.groups.repository.GroupDbo;
import com.jersey.groups.repository.GroupRepository;
import com.jersey.groups.resources.GroupResource;

import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.util.Duration;
import jakarta.ws.rs.client.Client;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App extends Application<ApplicationConfiguration> {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  @Override
  public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
  }

  @Override
  public void run(ApplicationConfiguration c, Environment e) throws Exception {

    LOGGER.info("Registering Jersey Client");
        // Configure JDBI with the read-write database
    

// Extract database configuration from ApplicationConfiguration
final ReadWriteDatabaseConfiguration rwDbConfig = c.getReadWriteDatabaseConfiguration();

// Convert ReadWriteDatabaseConfiguration to DataSourceFactory
final DataSourceFactory dataSourceFactory = new DataSourceFactory();
dataSourceFactory.setDriverClass("org.postgresql.Driver"); // Set the appropriate driver class
dataSourceFactory.setUrl(rwDbConfig.getJdbcUrl());
dataSourceFactory.setUser(rwDbConfig.user);
dataSourceFactory.setPassword(rwDbConfig.password);
dataSourceFactory.setMinSize(rwDbConfig.getMinimumIdle());
dataSourceFactory.setMaxSize(rwDbConfig.getMaximumPoolSize());
// Set the validation query
dataSourceFactory.setValidationQuery("SELECT 1"); // Replace with a suitable query

// Set the validation query timeout
dataSourceFactory.setValidationQueryTimeout(Duration.seconds(rwDbConfig.getValidationQueryTimeout()));


// Configure JDBI with the data source factory
final JdbiFactory factory = new JdbiFactory();
final Jdbi readWriteJdbi = factory.build(e, dataSourceFactory, "readWriteDB");

// Register the GroupDbo with JDBI
final GroupDbo groupDbo = readWriteJdbi.onDemand(GroupDbo.class);

GroupRepository repository = new GroupRepository(groupDbo);

e.jersey().register(groupDbo);

    final Client client = new JerseyClientBuilder(e)
            .using(c.getJerseyClientConfiguration())
            .build(getName());
    e.jersey().register(new GroupResource(repository));

    //****** Dropwizard security - custom classes ***********/
    e.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
            .setAuthenticator(new AppBasicAuthenticator())
            .setAuthorizer(new AppAuthorizer())
            .setRealm("BASIC-AUTH-REALM")
            .buildAuthFilter()));
    e.jersey().register(RolesAllowedDynamicFeature.class);
    e.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));

  }

  public static void main(String[] args) throws Exception {
    new App().run(args);
  }
}