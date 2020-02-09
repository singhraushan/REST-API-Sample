package com.rau.kafka.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rau.kafka.dto.ProductDto;
import com.rau.kafka.model.Product;
import com.rau.kafka.repository.ProductRepository;

@Service
public class KafkaConsumer {

	 private static final String TOPIC = "kafka-topic-dbs";
	 
	 @Autowired
	 ProductRepository productRepository;
	 
	 @KafkaListener(topics = TOPIC, group = "group_json",
	            containerFactory = "productKafkaListenerFactory")
	    public void consumeJson(ProductDto productDto) {
	        System.out.println("Consumed JSON Message: " + productDto);
	        productRepository.save(fromDto(productDto));
	    }
	 
	 private Product fromDto(ProductDto productDto){
		 Product product = new Product();
		 product.setProductId(productDto.getId());
		 product.setName(productDto.getName());
		 product.setPrice(productDto.getPrice());
		 return product;
	 }
}
