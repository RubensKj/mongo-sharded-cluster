package com.rubenskj.config.contract;

import org.aspectj.lang.ProceedingJoinPoint;

public interface MongoOperations {
    Object execute(ProceedingJoinPoint joinPoint) throws Throwable;
}
