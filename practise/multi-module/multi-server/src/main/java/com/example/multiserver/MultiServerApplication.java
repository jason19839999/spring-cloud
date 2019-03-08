package com.example.multiserver;

import com.example.multicommon.model.DecreaseStockInput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
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

        Map<String,Object> maps = new HashMap<String,Object>(100000000);
        for(int i =0;i<10000000;i++){
            maps.put(String.valueOf(i),  UUID.randomUUID().toString().replace("-", ""));
        }

        Set<String> sets = new HashSet<String>(100000000);

        Set<Map.Entry<String, Object>> set1 = maps.entrySet();
        Iterator<Map.Entry<String, Object>> iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Object> entry = iterator1.next();
            sets.add(String.valueOf(entry.getValue()));
        }

        int count = sets.size();
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

