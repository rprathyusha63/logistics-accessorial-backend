package org.vendors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class VendorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VendorsApplication.class, args);
    }
}
