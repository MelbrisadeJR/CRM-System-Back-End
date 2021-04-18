package com.melbrisade.project.services;

import com.melbrisade.project.entities.Product;
import com.melbrisade.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService{

    @Autowired
    private ProductRepository productRepository;

    public Product saveOrUpdateFeedback(Product product) {
        return productRepository.save(product);
    }

    public Product findProductById(Long id){
        return productRepository.findProductByProductID(id);
    }

    public Product findProductByProduct_name(String product_name){
        return productRepository.findProductByProductName(product_name);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
