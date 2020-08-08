package com.rubenskj.mongo.sharded.configuration;

import com.rubenskj.config.aspect.MongoConfiguration;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;

//@Dependent
public class AppConfig {

    public static final String DATABASE_NAME = "mongo-sharded";

    void startup(@Observes StartupEvent event) {
        new MongoConfiguration();
    }
}
