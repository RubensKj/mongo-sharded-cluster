package com.rubenskj.config.impl;

import com.rubenskj.config.contract.MongoOperations;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MongoOperationsImpl implements MongoOperations {

    private volatile int times = 0;

    @Override
    public Object execute(ProceedingJoinPoint joinPoint) throws InterruptedException {
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            Thread.sleep(3000);
            times++;

            if (times <= 3) {
                return execute(joinPoint);
            } else {
                return null;
            }
        }
    }
}
