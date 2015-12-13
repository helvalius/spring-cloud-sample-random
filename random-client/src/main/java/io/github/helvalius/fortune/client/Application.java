package io.github.helvalius.fortune.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
public class Application {
    private FeignFortune fortuneService;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Autowired
    public Application(FeignFortune fortuneService) {
        this.fortuneService = fortuneService;

        System.out.println(fortuneService.seed());
    }


}