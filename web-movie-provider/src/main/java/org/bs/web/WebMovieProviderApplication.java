package org.bs.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WebMovieProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebMovieProviderApplication.class, args);
    }

}
