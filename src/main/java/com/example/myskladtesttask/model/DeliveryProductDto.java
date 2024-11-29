package com.example.myskladtesttask.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryProductDto {

    private String documentName;

    private Long idProduct;

    private int countOfProduct;

}
