package com.rubenskj.mongo.sharded.service;


import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Test {

    public void serve() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Serving");
    }
}
