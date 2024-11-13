package com.example.customerBulkUpload.controller;

import com.example.customerBulkUpload.model.Customer;
import com.example.customerBulkUpload.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Endpoint to search customers
    @GetMapping("/search-customers")
    public ResponseEntity<List<Customer>> searchCustomers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String gender) {
        List<Customer> customers = customerService.searchCustomers(name, gender);
        return ResponseEntity.ok(customers);
    }

    // Endpoint to upload customer records
    @PostMapping("/upload-records")
    public ResponseEntity<List<Customer>> uploadRecords(@RequestBody List<Customer> customers) {
        List<Customer> uploadedCustomers = customerService.uploadRecords(customers);
        return ResponseEntity.ok(uploadedCustomers);
    }
}
