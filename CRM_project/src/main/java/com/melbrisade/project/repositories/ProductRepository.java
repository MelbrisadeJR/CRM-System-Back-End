package com.melbrisade.project.repositories;

import com.melbrisade.project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  Product findProductByProduct_name(String product_name);
}
