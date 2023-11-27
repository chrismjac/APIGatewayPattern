package com.edureka.customerservice.controllers;

import com.edureka.customerservice.entity.Customer;
import com.edureka.customerservice.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    @Operation(summary = "Add a new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "customer added successfully"),
            @ApiResponse(responseCode = "500", description = "Unable to add customer")})
    private ResponseEntity<String> addNewCustomer(@RequestBody Customer customer){
        return customerService.addNewCustomer(customer);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a customer by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Specified customer details retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No customer with specified Id found")})
    private ResponseEntity<?> getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }
}
