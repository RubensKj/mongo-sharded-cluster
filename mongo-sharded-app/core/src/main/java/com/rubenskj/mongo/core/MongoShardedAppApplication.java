package com.rubenskj.mongo.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MongoShardedAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoShardedAppApplication.class, args);
	}

}
