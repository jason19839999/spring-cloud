package com.eureka.order.VO;

import lombok.Data;

/**
 * Created by
 *
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
