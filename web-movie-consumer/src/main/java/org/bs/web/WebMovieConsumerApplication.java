package org.bs.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WebMovieConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebMovieConsumerApplication.class, args);
    }

}
