package com.zuul.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

@SpringBootApplication
@SpringCloudApplication
@EnableZuulProxy
public class ZuulServerApplication {

    public static void main(String[] args) {

         SpringApplication.run(ZuulServerApplication.class, args);
    }
    //动态路由设置 这里动态读取配置文件里面添加的路由规则 即：
// #    myorder:
// #     path: /myorder/**
// #     serviceId: order
// #     开启cookie，如果不设置，zuul不支持cookie设置和传递
// #     sensitiveHeaders:
 @ConfigurationProperties("zuul")
    @RefreshScope
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }
}
