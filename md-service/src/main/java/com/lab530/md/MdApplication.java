package com.lab530.md;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lab530.md.mapper")
@SpringBootApplication
public class MdApplication {
    public static void main(String[] args) {
        SpringApplication.run(MdApplication.class, args);
    }
}