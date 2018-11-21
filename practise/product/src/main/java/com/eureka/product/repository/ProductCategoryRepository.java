package com.eureka.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eureka.product.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
