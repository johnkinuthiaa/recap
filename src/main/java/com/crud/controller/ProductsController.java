package com.crud.controller;

import com.crud.model.Products;
import com.crud.service.ProductServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {
    private final ProductServiceInterface service;
    public ProductsController(ProductServiceInterface service){
        this.service =service;
    }

    @PostMapping("/new/product")
    public ResponseEntity<Products> createNewProduct(@RequestBody Products products){
        return ResponseEntity.ok(service.createNewProduct(products));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Products>> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }
    @PutMapping("/update")
    public ResponseEntity<Products> updateExistingProduct(@RequestBody Products product){
        return ResponseEntity.ok(service.updateExistingProduct(product));
    }
    @DeleteMapping("/delete/id")
    public void deleteProductById(@RequestParam Long id){
        service.deleteProductById(id);
    }
}
