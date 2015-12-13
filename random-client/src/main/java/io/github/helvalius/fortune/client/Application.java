package io.github.helvalius.fortune.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
@EnableFeignClients
public class Application {
    @Autowired
    private FeignFortune fortuneService;


    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);


        FeignFortune bean = ctx.getBean(FeignFortune.class);
        System.out.println(bean.seed());
    }

    public Application() {
        //System.out.println(fortuneService.seed());
    }

    public void setFortuneService(FeignFortune fortuneService) {
        this.fortuneService = fortuneService;
    }
}