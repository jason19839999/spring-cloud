package com.example.multiserver;

import com.example.multicommon.model.DecreaseStockInput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
public class MultiServerApplication {

    private final static AtomicLong sequenceNumber
            = new AtomicLong(1);
    public static long next() {
        synchronized (MultiServerApplication.class) {
            return sequenceNumber.getAndIncrement();
        }
    }







    public static void main(String[] args) {
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput();
        decreaseStockInput.setProductQuantity(10000);
        decreaseStockInput.setProductId("L24LJ64LHOGMVNOI213");
//        MultiServerApplication multiServerApplication = new MultiServerApplication();
        long test = next();
        long test2 = next();
        long test3 = next();
        long test4 = next();
        long test5 = next();
        long test6 = next();
        SpringApplication.run(MultiServerApplication.class, args);
    }

}

