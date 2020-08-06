package com.rubenskj.config.bean;

import com.rubenskj.config.annotation.MongoConfigured;
import com.rubenskj.config.codec.DocumentCodec;
import io.quarkus.runtime.Startup;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Startup
@ApplicationScoped
public class DocumentCodecBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentCodecBean.class);

    public <T, K> List<DocumentCodec<?, Object>> createAllDocumentCodec() {
        Reflections reflections = new Reflections("com.rubenskj");

        LOGGER.info("Creating beans with MongoConfigured");

        Set<Class<?>> annotatedWithMongoConfigured = reflections.getTypesAnnotatedWith(MongoConfigured.class);

        return annotatedWithMongoConfigured.stream().map(DocumentCodec::new).collect(Collectors.toList());
    }
}
