package com.example.sensitive;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author WenBin
 * @date 2022/07/26
 */
@SpringBootApplication
@MapperScan(basePackages = "com.example.sensitive.dao")
public class SensitiveWordAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SensitiveWordAdminApplication.class, args);
    }

}
