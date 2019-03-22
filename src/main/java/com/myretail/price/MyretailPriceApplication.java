package com.myretail.price;

import com.myretail.price.util.CassandraCluster;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyretailPriceApplication {

    @Bean
    public CassandraCluster getCassandraCluster(){
        return new CassandraCluster();
    }

    public static void main(String[] args) {
        SpringApplication.run(MyretailPriceApplication.class, args);
    }

}
