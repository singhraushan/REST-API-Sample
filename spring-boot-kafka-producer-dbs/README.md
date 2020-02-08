# Spring Boot with Kafka Producer 


#Zookeeper & Kafka should be running. 


This Project covers how to use Spring Boot with Spring Kafka to Publish message to a Kafka topic
## Start Zookeeper
- `bin/zookeeper-server-start.sh config/zookeeper.properties`

## Start Kafka Server
- `bin/kafka-server-start.sh config/server.properties`

## Create Kafka Topic
- `bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic kafka-example`

## Consume from the Kafka Topic via Console
- `bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic kafka-example --from-beginning`

## Publish message via Swagger
- `http://localhost:8081/swagger-ui.html#!/shopping-cart-controller/addProductUsingPOST`
