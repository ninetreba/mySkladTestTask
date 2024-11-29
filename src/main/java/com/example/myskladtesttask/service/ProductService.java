package com.example.myskladtesttask.service;

import com.example.myskladtesttask.exception.BusinessRuntimeException;
import com.example.myskladtesttask.exception.ErrorCodeEnum;
import com.example.myskladtesttask.model.Product;
import com.example.myskladtesttask.model.ProductDto;
import com.example.myskladtesttask.repository.ProductRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductService {


    private final ProductRepository productRepository;


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new BusinessRuntimeException(ErrorCodeEnum.PRODUCT_NOT_FOUND)
        );
    }


    public Product createProduct(@Valid ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setAvailable(productDto.isAvailable());

        productRepository.save(product);

        return product;
    }


    public void deleteProduct(@Valid Long id) {
        productRepository.deleteById(id);
    }


    public Product updateProduct(@Valid Product productNew) {
        Product product = getProductById(productNew.getId());

        product.setName(productNew.getName());
        product.setPrice(productNew.getPrice());
        product.setDescription(productNew.getDescription());
        product.setAvailable(productNew.isAvailable());

        productRepository.save(product);
        return product;
    }






    public List<Product> findAllByisAvailableTrue(){
        return productRepository.findAllByisAvailableTrue();
    }

    public List<Product> findAllByisAvailableFalse(){
        return productRepository.findAllByisAvailableFalse();
    }



    public List<Product> findAllByName(String name){
        return productRepository.findAllByName(name);
    }

    public List<Product> findByNameContaining(String namelike){
        return productRepository.findByNameContaining(namelike);
    }

    public List<Product> findByPrice(int price){
        return productRepository.findByPrice(price);
    }

    public List<Product> findByPriceGreaterThan(int price){
        return productRepository.findByPriceGreaterThan(price);
    }

    public List<Product> findByPriceLessThan(int price){
        return productRepository.findByPriceLessThan(price);
    }



    public List<Product> findByOrderByPriceAsc(){
        return productRepository.findByOrderByPriceAsc();
    }

    public List<Product> findByOrderByNameAsc(){
        return productRepository.findByOrderByNameAsc();
    }




    public List<Product> findByPriceGreaterThanOrderByNameDesc(int price){
        return productRepository.findByPriceGreaterThanOrderByNameDesc(price);
    }



    public List<Product> findByNameSortLimit(String name, int limit){
        return productRepository.findByNameSortLimit(name, limit);
    }






}


