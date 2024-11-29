package com.example.myskladtesttask.controller;


import com.example.myskladtesttask.model.Product;
import com.example.myskladtesttask.model.ProductDto;
import com.example.myskladtesttask.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;



    @GetMapping
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable @Min(0) Long id){
        return productService.getProductById(id);
    }


    @PostMapping
    public Product createProduct(@Valid @RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable @Min(0) Long id){
        productService.deleteProduct(id);
    }

    @PutMapping
    public Product updateProduct(@Valid @RequestBody Product product){
        return productService.updateProduct(product);
    }





}
