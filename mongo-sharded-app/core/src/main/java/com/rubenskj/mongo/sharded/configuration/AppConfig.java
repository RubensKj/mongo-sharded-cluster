package com.rubenskj.mongo.sharded.configuration;

import com.rubenskj.config.bean.DocumentCodecBean;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;

//@Dependent
public class AppConfig {

    public static final String DATABASE_NAME = "mongo-sharded-data";

//    @DefaultBean
//    public PlayerRepositoryImpl playerRepository() {
//        return new PlayerRepositoryImpl();
//    }

    void startup(@Observes StartupEvent event) {
        DocumentCodecBean documentCodecBean = new DocumentCodecBean();

        documentCodecBean.createAllDocumentCodec();
    }
}
