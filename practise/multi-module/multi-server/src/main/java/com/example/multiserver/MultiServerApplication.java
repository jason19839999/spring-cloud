package com.example.multiserver;

import com.example.multicommon.model.DecreaseStockInput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultiServerApplication {

    public static void main(String[] args) {
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput();
        decreaseStockInput.setProductQuantity(10000);
        decreaseStockInput.setProductId("L24LJ64LHOGMVNOI213");

        SpringApplication.run(MultiServerApplication.class, args);
    }

}

