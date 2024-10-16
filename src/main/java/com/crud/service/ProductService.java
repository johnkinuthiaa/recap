package com.crud.service;

import com.crud.model.Products;
import com.crud.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductServiceInterface{
    private final ProductsRepository repository;

    public ProductService(ProductsRepository repository){
        this.repository=repository;
    }
    @Override
    public List<Products> getAllProducts(){
        return repository.findAll();
    }
    @Override
    public List<Products> getProductByName(String name){
        return repository.findAll().stream()
                .filter(products -> products.getProductName().toLowerCase().equals(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public Products createNewProduct(Products products){
        Products products1 =new Products();
        try {
            if(repository.findById(products.getId()).isPresent()){
                throw new RuntimeException("product already exists");
            }else {
                products1.setProductName(products.getProductName());
                products1.setDescription(products.getDescription());
                products1.setStatus(products.getStatus());
                products1.setCreatedOn(LocalDateTime.now());
                repository.save(products1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    @Override
    public Products updateExistingProduct(Products product){
        Products products =new Products();
        try{
            if(repository.findById(product.getId()).isPresent()){
                repository.deleteById(product.getId());
                products.setProductName(product.getProductName());
                products.setDescription(product.getDescription());
                products.setStatus(product.getStatus());
                products.setCreatedOn(LocalDateTime.now());
                repository.save(products);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    @Override
    public  void deleteProductById(Long id){
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }else{
            throw new RuntimeException("item with id 1 not found");
        }
    }
}
