package com.eureka.product.controllelr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
public class MsgController {

    @GetMapping("/getMsg")
    public String getMsg() {

        return "come from msg111...";

    }
}
