package com.bol.service.checkout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.FeignClientScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@SpringBootApplication
//@EnableSwagger
@EnableDiscoveryClient
@EnableCircuitBreaker
@FeignClientScan(basePackages = "com.bol.service.giftcard")
@ComponentScan("com.bol.service.checkout")
public class CheckoutApplication {

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CheckoutApplication.class, args);
    }
}
