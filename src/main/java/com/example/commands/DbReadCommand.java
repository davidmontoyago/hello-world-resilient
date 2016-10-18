package com.example.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class DbReadCommand extends HystrixCommand<String> {

    protected DbReadCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    }

    @Override
    protected String run() throws Exception {
        Thread.sleep(100);
        return "World!";
    }
}
