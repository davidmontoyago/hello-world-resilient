package com.example;

import com.example.commands.DistributedHelloWorldCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;

@Configuration
@EnableAutoConfiguration
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
@RestController
public class ResilienceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResilienceApplication.class, args);
	}

	@RequestMapping("/")
	public String home() {
		Observable<String> observe = new DistributedHelloWorldCommand().observe();
		return observe.toBlocking().single();
	}

}
