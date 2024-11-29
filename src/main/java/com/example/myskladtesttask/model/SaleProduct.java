package com.example.myskladtesttask.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity(name = "sale_product")
public class SaleProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale_product")
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Column(name = "document_name")
    private String documentName;

    @ManyToOne
    @JoinColumn(name = "product_ref")
    private Product product;

    @Min(1)
    @Column(name = "count_of_product")
    private int countOfProduct;

    @Min(0)
    @Column(name = "price_of_sale")
    private double priceOfSale;

}
