package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan(basePackages = "com.cssl.dao")
@EnableDiscoveryClient
//@EnableFeignClients
@SpringBootApplication
public class Zhuyuanprovider1001Application {

    public static void main(String[] args) {
        SpringApplication.run(Zhuyuanprovider1001Application.class, args);
    }

}
