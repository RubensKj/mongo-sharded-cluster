package com.rubenskj.mongo.core.configuration;

import com.rubenskj.config.configuration.AspectConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public AspectConfiguration aspectConfiguration() {
        return new AspectConfiguration();
    }
}
