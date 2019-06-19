package org.bs.web;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan("org.bs.web.mapper")
public class WebProviderApplication {


    public static void main(String[] args) {

        System.setProperty("es.set.netty.runtime.available.processors","false");
        SpringApplication.run(WebProviderApplication.class, args);
    }

}
