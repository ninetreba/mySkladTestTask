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



}


