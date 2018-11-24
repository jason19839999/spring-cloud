package com.eureka.product.controllelr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
public class MsgController {

    @GetMapping("/getMsg")
    public String getMsg() {
<<<<<<< HEAD
        return "come from msg111111...";
=======

        return "come from msg111...";

>>>>>>> 4aa9648ae8d3718177a7f0a6d6e45fcbc87546ed
    }
}
