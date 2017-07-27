package com.misnearzhang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;


/**
 * Created by zhanglong on 2017/7/14.
 */
@SpringBootApplication
public class AppIndex {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(
                AppIndex.class);
        application.addListeners(
                new ApplicationPidFileWriter("app.pid"));
        application.run(args);
    }

    @Bean
    public CorsConfiguration corsConfiguration(){
        return new CorsConfiguration();
    }
}
