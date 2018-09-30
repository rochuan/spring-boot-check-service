package com.mdx.spider.provider;

import com.mdx.spider.provider.config.EnableMybatis;
import com.mdx.spider.provider.excutor.SpiderPageExcutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Configuration
@EnableMybatis(basePackage = "com.mdx.spider.provider.dao", pojoPackage = "com.mdx.spider.api.pojo.domain")
@EnableScheduling
public class SpiderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpiderServiceApplication.class, args);
    }

}


