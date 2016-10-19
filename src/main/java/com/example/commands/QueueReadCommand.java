package com.example.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class QueueReadCommand extends HystrixCommand<String> {

    protected QueueReadCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    }

    @Override
    protected String run() throws Exception {
        Thread.sleep(100);
        return "Hello";
    }

    @Override
    protected String getFallback() {
        return "[Fallback] Hello";
    }
}
