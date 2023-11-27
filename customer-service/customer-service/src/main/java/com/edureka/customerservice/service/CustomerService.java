package com.edureka.customerservice.service;

import com.edureka.customerservice.entity.Customer;
import com.edureka.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public ResponseEntity<String> addNewCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
            return new ResponseEntity<>("Customer Details added successfully", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>("Exception raised while adding new customer" + exception.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getCustomerById(Long id) {
        Optional<Customer> orderDetails = customerRepository.findById(id);
        if (orderDetails.isPresent()) {
            return ResponseEntity.ok(orderDetails.get());
        }
        return new ResponseEntity<>("No customer with specified Id found", HttpStatus.NOT_FOUND);
    }
}
