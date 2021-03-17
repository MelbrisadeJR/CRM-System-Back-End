package com.melbrisade.project.repositories;

import com.melbrisade.project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  Product findProductByProductName(String product_name);

  Product findProductByProductID(Long id);
}
