package com.edureka.orderservice.service;

import com.edureka.orderservice.entity.Orders;
import com.edureka.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    public ResponseEntity<String> addNewOrder(Orders order) {

        try {
            orderRepository.save(order);
            return new ResponseEntity<>("Order Details added successfully", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>("Exception raised while adding new order" + exception.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    public ResponseEntity<?> getOrderById(Long id) {
        Optional<Orders> orderDetails = orderRepository.findById(id);
        if (orderDetails.isPresent()) {
            return ResponseEntity.ok(orderDetails.get());        }
        return new ResponseEntity<>("No order with specified Id found", HttpStatus.NOT_FOUND);
    }

}
