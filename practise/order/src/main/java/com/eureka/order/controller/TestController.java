package com.eureka.order.controller;

import com.eureka.order.VO.ResultVO;
import com.eureka.order.dataobject.OrderDetail;
import com.eureka.order.dto.OrderDTO;
import com.eureka.order.dto.ProductInfoOutput;
import com.eureka.order.feign_client.ProductClient;
import com.eureka.order.service.OrderService;
import com.eureka.order.utils.ResultVOUtil;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderService orderService;


    @GetMapping("/testListProducts")
    public String testListProducts(){
        List<String> lst = Arrays.asList("157875196366160022","157875227953464068");
        List<ProductInfoOutput> lstProducts = productClient.listForOrder(lst);
        System.out.println(lstProducts);
        return "OK";
    }

    @GetMapping("/testCreate")
    public ResultVO<Map<String, String>> create(){

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerAddress("太阳宫");
        orderDTO.setBuyerOpenid("AOUIOAO23423");
        orderDTO.setBuyerPhone("234234234");
        orderDTO.setOrderAmount(BigDecimal.ZERO);
        orderDTO.setOrderId("afaf4324");
        orderDTO.setOrderStatus(0);
        List<OrderDetail> lst = new ArrayList<OrderDetail>();
        OrderDetail objOrderDetail = new OrderDetail();
        objOrderDetail.setProductId("157875196366160022");
        objOrderDetail.setProductQuantity(2);
        lst.add(objOrderDetail);
        orderDTO.setOrderDetailList(lst);
        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }

//    @GetMapping("/testMsg")
//    public String testMsg(){
//        //① @LoadBalancerClient
//        ServiceInstance serviceInstance =loadBalancerClient.choose("product");
//        String host = serviceInstance.getHost();
//        int port = serviceInstance.getPort();
//        ResponseEntity<String> response =restTemplate.exchange("http://" + host + ":"+ port + "/msg/getMsg",HttpMethod.POST,null,String.class);
//        return response.getBody();
//    }


}
