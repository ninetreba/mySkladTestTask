package com.example.myskladtesttask.service;

import com.example.myskladtesttask.model.DeliveryProduct;
import com.example.myskladtesttask.model.Product;
import com.example.myskladtesttask.model.dto.DeliveryProductDto;
import com.example.myskladtesttask.repository.DeliveryProductRepository;
import com.example.myskladtesttask.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class DeliveryProductService {

    private final DeliveryProductRepository deliveryProductRepository;
    private final ProductRepository productRepository;


    public List<DeliveryProduct> getAllDelivery() {
        return deliveryProductRepository.findAll();
    }

    public DeliveryProduct createDeliveryProduct(DeliveryProductDto deliveryProductDto) {
        Product product = productRepository.findById(deliveryProductDto.getIdProduct()).orElseThrow(null);

        DeliveryProduct dp = new DeliveryProduct();
        dp.setProduct(product);
        dp.setDocumentName(deliveryProductDto.getDocumentName());
        dp.setCountOfProduct(deliveryProductDto.getCountOfProduct());

        deliveryProductRepository.save(dp);

        return dp;

    }






}
