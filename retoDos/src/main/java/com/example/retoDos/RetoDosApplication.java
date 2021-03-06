package com.example.retoDos;

import com.example.retoDos.Order.OrderCrudRepository;
import com.example.retoDos.Product.ProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class RetoDosApplication implements CommandLineRunner {

    @Autowired
    private OrderCrudRepository orderCrudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private ProductCrudRepository productCrudRepository;

    public static void main(String[] args) {
        SpringApplication.run(RetoDosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productCrudRepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
    }

}
