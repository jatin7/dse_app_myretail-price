package com.myretail.price.service;

import com.myretail.price.model.Price;
import com.myretail.price.repository.ProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductPriceRepository priceRepository;

    public Price getProductPriceById(long productId) throws Exception {

        return priceRepository.getProductPrice(productId);

    }

}
