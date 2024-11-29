package com.example.myskladtesttask.service;

import com.example.myskladtesttask.exception.BusinessRuntimeException;
import com.example.myskladtesttask.exception.ErrorCodeEnum;
import com.example.myskladtesttask.model.Product;
import com.example.myskladtesttask.model.ProductDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {


    private static Long PRODUCT_COUNT= 1L;
    private List<Product> productList;


    {
        productList = new ArrayList<>();

        productList.add(new Product(PRODUCT_COUNT++,"wath", "new watch", 24800, true));
        productList.add(new Product(PRODUCT_COUNT++,"phone", "new phone", 17500, false));
        productList.add(new Product(PRODUCT_COUNT++,"laptop", "new laptop", 98000, true));

        System.out.println("hello");

    }



    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProductById(Long id) {
        return productList.stream().filter(product -> product.getId() == id).findAny().orElseThrow(
                () -> new BusinessRuntimeException(ErrorCodeEnum.PRODUCT_NOT_FOUND)
        );
    }


    public Product createProduct(@Valid ProductDto productDto) {
        Product product = new Product();
        product.setId(PRODUCT_COUNT++);
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setAvailable(productDto.isAvailable());

        productList.add(product);

        return product;
    }


    public void deleteProduct(Long id) {
        productList.removeIf(p -> p.getId() == id);
    }


    public Product updateProduct(@Valid Product productNew) {
        Product product = getProductById(productNew.getId());

        product.setName(productNew.getName());
        product.setPrice(productNew.getPrice());
        product.setDescription(productNew.getDescription());
        product.setAvailable(productNew.isAvailable());

        return product;
    }






}
