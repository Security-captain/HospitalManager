package com.zy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.zy.dao")
@SpringBootApplication
public class PharmacyProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmacyProviderApplication.class, args);
    }

}
