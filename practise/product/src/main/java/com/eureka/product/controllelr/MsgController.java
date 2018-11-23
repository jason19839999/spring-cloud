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
        return "come from msg2...";
=======
        return "come from msg222222...";
>>>>>>> 9254dcd3bee5272a98aded31bcf954d120297153
    }
}
