package com.rubenskj.config.interfaces;

@FunctionalInterface
public interface ExecuteWithReturn<T> {

    void execute(T t);
}
