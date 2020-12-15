package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class Zhuyuanconsumer1002Application {

    public static void main(String[] args) {
        SpringApplication.run(Zhuyuanconsumer1002Application.class, args);
    }

}
