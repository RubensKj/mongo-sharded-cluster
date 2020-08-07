package com.rubenskj.config.interfaces;

@FunctionalInterface
public interface IMongoHandlerOperation {

    Object execute(ExecuteWithReturn<Object> proceed);
}
