package com.account.manager.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.account.manager.api.service")
public class AccountManagerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountManagerApiApplication.class, args);
    }

}
