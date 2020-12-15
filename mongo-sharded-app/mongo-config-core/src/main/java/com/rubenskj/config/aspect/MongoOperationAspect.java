package com.rubenskj.config.aspect;

import com.rubenskj.config.contract.MongoOperations;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MongoOperationAspect implements Ordered {

    private final MongoOperations mongoOperations;

    public MongoOperationAspect(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Around("target(org.springframework.data.mongodb.core.MongoOperations) || this(org.springframework.data.mongodb.core.MongoOperations)")
    public Object processDocumentsToDataSource(ProceedingJoinPoint joinPoint) throws Throwable {
        return this.mongoOperations.execute(joinPoint);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
