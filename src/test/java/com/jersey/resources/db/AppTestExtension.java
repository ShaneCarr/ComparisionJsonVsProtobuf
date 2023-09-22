package com.jersey.resources.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jersey.App;
import com.jersey.config.ApplicationConfiguration;

import io.dropwizard.configuration.ConfigurationException;
import io.dropwizard.configuration.ConfigurationFactory;
import io.dropwizard.configuration.ConfigurationSourceProvider;
import io.dropwizard.configuration.FileConfigurationSourceProvider;
import io.dropwizard.configuration.YamlConfigurationFactory;
//import io.dropwizard.testing.ConfigOverride;
import io.dropwizard.testing.ConfigOverride;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;

import org.junit.jupiter.api.extension.*;
import org.hibernate.validator.HibernateValidator;
import org.jdbi.v3.core.Jdbi;

import java.io.IOException;
import java.util.function.Supplier;

/*
test extension
 */
public class AppTestExtension implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {

    private final String configPath;


    public AppTestExtension(String configPath)  {

        try{
        ConfigurationSourceProvider provider = new FileConfigurationSourceProvider();

    // Create a ConfigurationFactory for your ApplicationConfiguration class
    // ConfigurationFactory<ApplicationConfiguration> factory = new YamlConfigurationFactory<>(
    //         ApplicationConfiguration.class,
    //         getValidatorFactory().getValidator(),
    //         getObjectMapper(),
    //         "");
            
        // var x= factory.build(provider, configPath);
        
    
        db = PostgresTestContainer.create();
        db.start();
        Supplier<String> readOnlyJdbcUrlSupplier = db::jdbcUrl;

        app = new DropwizardAppExtension<>(App.class,
                configPath,
                ConfigOverride.config("readOnlyDatabase.jdbcUrl", readOnlyJdbcUrlSupplier),
                ConfigOverride.config("readWriteDatabase.jdbcUrl", readOnlyJdbcUrlSupplier)
        );

        this.configPath = configPath;
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    }

 

    private ValidatorFactory getValidatorFactory() {
    return Validation.byProvider(HibernateValidator.class)
            .configure()
            .buildValidatorFactory();
}

private ObjectMapper getObjectMapper() {
    return new ObjectMapper();
}

    private final DropwizardAppExtension<ApplicationConfiguration>  app;

   private final PostgresTestContainer db;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {

        db.start();
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        db.stop();
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        // Perform any setup before each test
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        // Perform any cleanup after each test
    }

    public DropwizardAppExtension<ApplicationConfiguration> getApp() {
        return app;
    }
}
