package com.example.myskladtesttask.repository;

import com.example.myskladtesttask.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findAllByName(String name);
    List<Product> findByNameContaining(String nameLike);

    List<Product> findByPrice(int price);
    List<Product> findByPriceGreaterThan(int price);
    List<Product> findByPriceLessThan(int price);

    List<Product>findAllByisAvailableTrue();
    List<Product>findAllByisAvailableFalse();

    List<Product> findByOrderByPriceAsc();
    List<Product> findByOrderByNameAsc();



    List<Product>findByPriceGreaterThanOrderByNameDesc(int price);

    @Query(value = "SELECT * FROM product p where p.name = ?1" +
            " ORDER BY p.price LIMIT ?2", nativeQuery = true)
    List<Product> findByNameSortLimit(String name, int limit);

}
