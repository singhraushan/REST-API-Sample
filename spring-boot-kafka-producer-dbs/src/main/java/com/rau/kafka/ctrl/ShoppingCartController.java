package com.rau.kafka.ctrl;

import com.rau.kafka.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingCartController {

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    private static final String TOPIC = "kafka-example";

    @ApiOperation(value = "passing product details to kafka")
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@RequestBody Product product) {

        kafkaTemplate.send(TOPIC, product);

        return "Published successfully";
    }
}
