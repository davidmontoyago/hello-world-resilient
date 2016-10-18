package com.example.commands;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;

public class DistributedHelloWorldCommand extends HystrixObservableCommand<String> {

    public DistributedHelloWorldCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    }

    @Override
    protected Observable<String> construct() {
        return new GetResourceCommand().observe();
    }
}
