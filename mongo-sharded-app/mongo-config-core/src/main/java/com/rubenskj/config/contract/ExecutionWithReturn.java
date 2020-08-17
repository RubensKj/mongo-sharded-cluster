package com.rubenskj.config.contract;

@FunctionalInterface
public interface ExecutionWithReturn<T> {
    T execute() throws Throwable;
}
