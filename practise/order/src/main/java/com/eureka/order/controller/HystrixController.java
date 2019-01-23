package com.eureka.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by
 *
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

	//超时配置  默认为1000ms = 1秒   如果配置文件配置了超时  →  时间那么此处就失效了
//	@HystrixCommand(commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//	})

//	@HystrixCommand(commandProperties = {
//			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  				//设置熔断
//			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),	//请求数达到后才计算
//			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
//			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),	//错误率
//	})
	@HystrixCommand
	@GetMapping("/getProductInfoList")
	public String getProductInfoList(@RequestParam("number") Integer number) throws InterruptedException {
		if (number % 2 == 0) {
			return "success";
		}
        Thread.sleep(2000);
		return  "ok";
//		RestTemplate restTemplate = new RestTemplate();
//		return restTemplate.postForObject("http://127.0.0.1:8005/product/listForOrder",
//				Arrays.asList("157875196366160022"),
//				String.class);

// 注意一下：接口内部如果异常也会触发降级
//		throw new RuntimeException("发送异常了");
	}

	private String fallback() {
		return "太拥挤了, 请稍后再试~~";
	}

	private String defaultFallback() {
		return "默认提示：太拥挤了, 请稍后再试~~";
	}
}
