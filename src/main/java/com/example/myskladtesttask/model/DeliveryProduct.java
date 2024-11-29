package com.example.myskladtesttask.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "delivery_product")
public class DeliveryProduct {


    @Id
    @Column(name = "id_delivery_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


}


