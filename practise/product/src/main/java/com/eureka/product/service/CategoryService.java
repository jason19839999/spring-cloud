package com.eureka.product.service;


import com.eureka.product.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
