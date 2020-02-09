package com.rau.kafka.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rau.kafka.dto.ProductDto;

import io.swagger.annotations.ApiOperation;

@RestController
public class ShoppingCartController {

    @Autowired
    private KafkaTemplate<String, ProductDto> kafkaTemplate;

    private static final String TOPIC = "kafka-topic-dbs";

    @ApiOperation(value = "passing product details to kafka")
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@RequestBody ProductDto productDto) {

    	System.out.println("pushing productDto: "+productDto+" to kafka topic: "+TOPIC);
        kafkaTemplate.send(TOPIC, productDto);

        return "Published successfully";
    }
}
