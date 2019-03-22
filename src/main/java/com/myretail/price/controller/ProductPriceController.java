package com.myretail.price.controller;

import com.myretail.price.model.Price;
import com.myretail.price.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/productPrice")
@RestController
public class ProductPriceController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> getProductById(@PathVariable("id") long productId) throws Exception {


        Price price = productService.getProductPriceById(productId);

        return new ResponseEntity<Price>(price, HttpStatus.OK);

    }

}
