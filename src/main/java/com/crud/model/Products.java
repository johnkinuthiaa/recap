package com.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String description;
    private String status;
    private LocalDateTime createdOn;

    public Products(){}
    public Products(String productName,String description,String status,LocalDateTime createdOn){
        this.productName=productName;
        this.description=description;
        this.status=status;
        this.createdOn=createdOn;
    }
    public Long getId(){
        return id;
    }
    public void setProductName(String productName){
        this.productName =productName;

    }
    public String getProductName(){
        return productName;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public String getStatus(){
        return status;
    }
    public void setCreatedOn(LocalDateTime createdOn){
        this.createdOn =createdOn;
    }
    public LocalDateTime getCreatedOn(){
        return createdOn;
    }


}
