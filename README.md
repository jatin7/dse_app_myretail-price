# myretail-price
retail price service to pull data from cassandra

#Build Cassandra Cluster in the local machine
1. Downloaded cassandra using 
LM00089:~ vgupta$ wget --user yvgupta4_gmail.com --password dY03BjPvMlgPBBo -L https://downloads.datastax.com/enterprise/dse.tar.gz

2. Downloaded file "dense-install.sh" from 
https://www.datastax.com/dev/blog/running-multiple-datastax-enterprise-nodes-in-a-single-host

3. ran the command by giving cluster name and number of nodes
$ ./dense-install.sh lmncluster 3

4. Downloaded file "with-dse-env.sh" from 
https://www.datastax.com/dev/blog/running-multiple-datastax-enterprise-nodes-in-a-single-host

5. ran the command
$ ./with-dse-env.sh node1 bin/dse cassandra -f

6. ran the command
cd /var/lib/

8. ran the commands
sudo mkdir cassandra
sudo chmod 777 cassandra
cd /Users/username/
./with-dse-env.sh node1 bin/dse cassandra -f
sudo ifconfig lo0 alias 127.0.0.1
sudo ifconfig lo0 alias 127.0.0.2
sudo ifconfig lo0 alias 127.0.0.3

9. Updated the port of node2 at /node2/resources/dse/conf/dse.yaml as.. from 8609 to 8610 (since node1 has 8609)
internode_messaging_options:
    # TCP listen port (mandatory)
    port: 8610
    
10. Updated the port of node3 at /node3/resources/dse/conf/dse.yaml as.. from 8609 to 8611 (since node1 has 8609)
internode_messaging_options:
    # TCP listen port (mandatory)
    port: 8611

11. Also, updated the ports for node2 at /node2/resources/cassandra/conf/cassandra.yaml as.. from 9042 to 9043
native_transport_port: 9043

12. Also, updated the ports for node3 at /node3/resources/cassandra/conf/cassandra.yaml as.. from 9042 to 9044
native_transport_port: 9044

13. ran the commands, each one at separate terminal
./with-dse-env.sh node1 bin/dse cassandra -f
./with-dse-env.sh node2 bin/dse cassandra -f
./with-dse-env.sh node3 bin/dse cassandra -f

14. ran the command at different terminal 
cd dse-6.7.2/bin/
./nodetool status

15. Create keyspace and insert the sample data
$ ./cqlsh 
Connected to lmncluster at 127.0.0.1:9042.
[cqlsh 5.0.1 | DSE 6.7.2 | CQL spec 3.4.5 | DSE protocol v2]
Use HELP for help.
cqlsh> CREATE KEYSPACE MyRetail WITH replication = { 'class' : 'SimpleStrategy', 'replication_factor' : 2 };
cqlsh> use myretail ;
cqlsh:myretail> CREATE TABLE ProductPrices(productid bigint, price double, currency text, PRIMARY KEY (productid));
cqlsh:myretail> select * from productprices ;

 productid | currency | price
-----------+----------+-------

(0 rows)
cqlsh:myretail> INSERT INTO ProductPrices (productid, price, currency) VALUES (13860428, 13.49, 'USD');
cqlsh:myretail> INSERT INTO ProductPrices (productid, price, currency) VALUES (15117729, 45.49, 'USD');
cqlsh:myretail> INSERT INTO ProductPrices (productid, price, currency) VALUES (16483589, 13.00, 'USD');
cqlsh:myretail> INSERT INTO ProductPrices (productid, price, currency) VALUES (16696652, 83.49, 'EUR');
cqlsh:myretail> INSERT INTO ProductPrices (productid, price, currency) VALUES (16752456, 273.88, 'AED');
cqlsh:myretail> INSERT INTO ProductPrices (productid, price, currency) VALUES (15643793, 13.49, 'USD');
cqlsh:myretail> select * from productprices ;

 productid | currency | price
-----------+----------+--------
  16696652 |      EUR |  83.49
  13860428 |      USD |  13.49
  15643793 |      USD |  13.49
  15117729 |      USD |  45.49
  16483589 |      USD |     13
  16752456 |      AED | 273.88

(6 rows)
cqlsh:myretail> exit
