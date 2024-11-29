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






    @GetMapping("/search/availableTrue")
    public List<Product> findAllByisAvailableTrue() {
        return productService.findAllByisAvailableTrue();
    }

    @GetMapping("/search/availableFalse")
    public List<Product> findAllByisAvailableFalse() {
        return productService.findAllByisAvailableFalse();
    }



    @GetMapping("/search/name/{name}")
    public List<Product> findAllByName(@PathVariable String name) {
        return productService.findAllByName(name);
    }

    @GetMapping("/search/nameContaining/{namelike}")
    public List<Product> findByNameContaining(@PathVariable String namelike) {
        return productService.findByNameContaining(namelike);
    }



    @GetMapping("/search/price/{price}")
    public List<Product> findByPrice(@PathVariable int price) {
        return productService.findByPrice(price);
    }

    @GetMapping("/search/priceMoreThan/{price}")
    public List<Product> findByPriceGreaterThan(@PathVariable int price) {
        return productService.findByPriceGreaterThan(price);
    }

    @GetMapping("/search/priceMoreLess/{price}")
    public List<Product> findByPriceLessThan(@PathVariable int price) {
        return productService.findByPriceLessThan(price);
    }



    @GetMapping("sort/price")
    public List<Product> findByOrderByPriceAsc() {
        return productService.findByOrderByPriceAsc();
    }

    @GetMapping("sort/name")
    public List<Product> findByOrderByNameAsc() {
        return productService.findByOrderByNameAsc();
    }



    @GetMapping("findAndSort/priceGreaterSort/{price}")
    public List<Product> findByPriceGreaterThanOrderByNameDesc(@PathVariable int price) {
        return productService.findByPriceGreaterThanOrderByNameDesc(price);
    }

    @GetMapping("/findAndSort/nameSort/{name}/{limit}")
    public List<Product> findByNameSortLimit(@PathVariable String name, @PathVariable int limit) {
        return productService.findByNameSortLimit(name, limit);
    }






}
