package com.ssau.restfulesa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@ServletComponentScan //добавлено для JMS
@EnableJms //добавлено для JMS
public class RestfulesaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulesaApplication.class, args);
    }

}
