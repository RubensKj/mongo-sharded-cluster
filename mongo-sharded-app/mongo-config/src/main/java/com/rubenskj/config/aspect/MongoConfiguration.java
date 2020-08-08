package com.rubenskj.config.aspect;

import com.rubenskj.config.interfaces.ExecuteWithReturn;
import com.rubenskj.config.interfaces.IMongoHandlerOperation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Aspect
@ApplicationScoped
public class MongoConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoConfiguration.class);

    @Inject
    IMongoHandlerOperation IMongoHandlerOperation;

    @Around("target(com.mongodb.internal.operation.Operations) || this(com.mongodb.internal.operation.Operations)")
    public Object executeMongoOperations(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("Handling Mongo Operation..");
        System.out.println("To Aquiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        return this.IMongoHandlerOperation.execute((ExecuteWithReturn<Object>) joinPoint.proceed());
    }
}
