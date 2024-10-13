package com.crud.repository;

import com.crud.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products,Long> {
    Optional<Products> findProductById(Long id);
}
