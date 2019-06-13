package org.bs.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan("org.bs.web.mapper.dyl")
public class WebProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebProviderApplication.class, args);
    }

}
