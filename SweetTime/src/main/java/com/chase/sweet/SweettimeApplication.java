package com.chase.sweet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chase
 */
@SpringBootApplication
@MapperScan("com.chase.sweet.mapper")
public class SweettimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SweettimeApplication.class, args);
    }

}
