package com.rubenskj.mongo.sharded.configuration;

import com.rubenskj.mongo.sharded.persistence.PlayerRepositoryImpl;
import io.quarkus.arc.DefaultBean;

import javax.enterprise.context.Dependent;

//@Dependent
public class AppConfig {

    public static final String DATABASE_NAME = "mongo-sharded-data";

//    @DefaultBean
//    public PlayerRepositoryImpl playerRepository() {
//        return new PlayerRepositoryImpl();
//    }
}
