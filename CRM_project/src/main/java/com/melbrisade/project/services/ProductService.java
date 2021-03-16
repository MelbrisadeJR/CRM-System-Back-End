package com.melbrisade.project.services;

import com.melbrisade.project.entities.Product;
import com.melbrisade.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductService{

    @Autowired
    private ProductRepository productRepository;

    public Product findProductById(Long id){
        return productRepository.findProductById(id).get();
    }

    public Product findProductByProduct_name(String product_name){
        return productRepository.findProductByProduct_name(product_name);
    }
}
