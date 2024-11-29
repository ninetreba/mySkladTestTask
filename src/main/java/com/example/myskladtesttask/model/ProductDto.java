package com.example.myskladtesttask.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductDto {

    @NotNull(message = "Product name is required")
    @Size(max = 10 , message = "Product name cannot exceed " + 255  + " characters")
    private String name;

    @Size(max = 4096, message = "Description cannot exceed " + 4096 + " characters")
    private String description;

    @Min(value = 0, message = "Price cannot be less than 0")
    private int price = 0;

    private boolean isAvailable = false;

}

