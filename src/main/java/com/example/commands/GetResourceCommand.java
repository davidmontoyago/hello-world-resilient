package com.example.commands;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;

public class GetResourceCommand extends HystrixObservableCommand<String> {

    protected GetResourceCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    }

    @Override
    protected Observable<String> construct() {
        Observable<String> helloResponse = new QueueReadCommand().observe();
        Observable<String> worldResponse = new DbReadCommand().observe();
        return Observable.zip(helloResponse, worldResponse, (s1, s2) -> s1 + " " + s2);
    }
}
