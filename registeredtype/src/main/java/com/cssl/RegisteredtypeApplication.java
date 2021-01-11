package com.cssl;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan(basePackages = "com.cssl.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class RegisteredtypeApplication {

    public static void main(String[] args) {

        SpringApplication.run(RegisteredtypeApplication.class, args);

    }

}
