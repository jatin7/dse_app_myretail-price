package com.myretail.price.repository;

import com.myretail.price.model.Price;

public interface ProductPriceRepository {

    public Price getProductPrice(long productId);

}
