package com.example.myskladtesttask.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product name is required")
    @Size(max = 255 , message = "Product name cannot exceed 255 characters")
    private String name;

    @Size(max = 4096, message = "Description cannot exceed 4096 characters")
    private String description;

    @Min(value = 0, message = "Price cannot be less than 0")
    private int price = 0;

    @Column(name = "available")
    private boolean isAvailable = false;


    public Product(){}

    public Product(Long id, String name, String description, int price, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
    }




}

