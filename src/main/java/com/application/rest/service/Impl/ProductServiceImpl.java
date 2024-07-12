package com.application.rest.service.Impl;

import com.application.rest.entities.Product;
import com.application.rest.persistence.IProductDAO;
import com.application.rest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDAO productDAO;

    @Override
    public List<Product> findAll() {
        return this.productDAO.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productDAO.findById(id);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return this.productDAO.findByPriceInRange(minPrice,maxPrice);
    }

    @Override
    public void save(Product product) {
        this.productDAO.save(product);
    }

    @Override
    public void deleteById(Long id) {
        this.productDAO.deleteById(id);
    }
}
