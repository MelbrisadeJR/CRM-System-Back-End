package com.melbrisade.project.controllers;

import com.melbrisade.project.entities.Product;
import com.melbrisade.project.services.ProductService;
import com.melbrisade.project.services.ValidationServiceError;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private final ProductService productService;

    @Autowired
    private ValidationServiceError validationServiceError;

    @GetMapping
    public ResponseEntity<List<Product>> findProducts(){
        List<Product> productList = productService.findAllProducts();
        return ResponseEntity.ok(productList);
    }

    @PostMapping
    public ResponseEntity<?> createNewProduct(@Valid @RequestBody Product product, BindingResult result) {
        ResponseEntity<?> errMap = validationServiceError.ValidationService(result);

        if (errMap != null) {
            return errMap;
        }

        Product productToCreate = productService.saveOrUpdateFeedback(product);
        return new ResponseEntity<>(productToCreate, HttpStatus.CREATED);
    }
}
