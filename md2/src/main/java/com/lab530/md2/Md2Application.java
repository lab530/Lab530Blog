package com.lab530.md2;


import com.lab530.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.lab530.api.client",defaultConfiguration = DefaultFeignConfig.class)
@MapperScan("com.lab530.md2.mapper")
@SpringBootApplication
public class Md2Application {
    public static void main(String[] args) {
        SpringApplication.run(Md2Application.class, args);
    }
}