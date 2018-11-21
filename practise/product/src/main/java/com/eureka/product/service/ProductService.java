package com.eureka.product.service;


import com.eureka.product.dataobject.DecreaseStockInput;
import com.eureka.product.dataobject.ProductInfo;
import com.eureka.product.dataobject.ProductInfoOutput;

import java.util.List;

/**
 * Created by
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     *
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
