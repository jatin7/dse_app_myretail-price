package com.myretail.price.repository;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.myretail.price.model.Price;
import com.myretail.price.util.CassandraCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductPriceCassandraRepository implements ProductPriceRepository{

    @Autowired
    CassandraCluster cassandraCluster;

    public Price getProductPrice(long productId){

        Session session = cassandraCluster.getSession();
        ResultSet results = session.execute("SELECT * FROM ProductPrices WHERE productid=" + productId);
        Price price = new Price();
        for (Row row : results) {
            price.setCurrencyCode(row.getString("currency"));
            price.setValue(row.getDouble("price"));
        }
        session.close();

        return price;
    }
}
