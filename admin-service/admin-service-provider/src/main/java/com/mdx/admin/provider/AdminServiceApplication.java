package com.mdx.admin.provider;


import com.mdx.admin.provider.config.EnableMybatis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableMybatis(basePackage = "com.mdx.admin.provider.dao",

        pojoPackage = "com.mdx.admin.api.pojo.dto")
public class AdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApplication.class, args);
    }

}


