package com.application.rest.controller;

import com.application.rest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private IProductService productService;

    @Autowired
    private ProductController(IProductService productService){
        this.productService = productService;
    }



}
