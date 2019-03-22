package com.myretail.price.util;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Value;

public class CassandraCluster {

    private Cluster cluster;
    private Session session;

    @Value("${cassandra.keyspace}")
    private String serviceURL;

    @Value("${cassandra.port}")
    private int port;

    public Session getSession(){
        cluster = Cluster.builder().addContactPoint("localhost").withPort(port).build();
        session = cluster.connect("myretail");

        return session;
    }

}
