package com.rubenskj.config.service;

import com.rubenskj.config.interfaces.ExecuteWithReturn;
import com.rubenskj.config.interfaces.IMongoHandlerOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MongoHandlerOperationImpl implements IMongoHandlerOperation {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoHandlerOperationImpl.class);

    @Override
    public Object execute(ExecuteWithReturn<Object> proceed) {
        LOGGER.info("Handling mongo operation");
        LOGGER.debug("Operation: {}", proceed);

        return null;
    }
}
