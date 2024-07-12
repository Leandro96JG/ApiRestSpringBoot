package com.application.rest.repository;

import com.application.rest.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    //* Consultas personalizadas

    //con jpql // se puede hacer con >= ?1 AND p.price <= ?2
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findProductByPriceInRange(BigDecimal minPrice, BigDecimal maxDecimal);

    //Con query metods
    List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxDecimal);
}
