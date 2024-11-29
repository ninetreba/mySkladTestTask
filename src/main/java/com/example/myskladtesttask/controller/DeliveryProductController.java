package com.example.myskladtesttask.controller;

import com.example.myskladtesttask.model.DeliveryProduct;
import com.example.myskladtesttask.model.dto.DeliveryProductDto;
import com.example.myskladtesttask.service.DeliveryProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryProductController {

    private DeliveryProductService deliveryProductService;

    @GetMapping
    public List<DeliveryProduct> getAllDelivery(){
        return deliveryProductService.getAllDelivery();
    }

    @PostMapping
    public DeliveryProduct createDeliveryProduct(@RequestBody DeliveryProductDto deliveryProductDto) {
        return deliveryProductService.createDeliveryProduct(deliveryProductDto);
    }





}
