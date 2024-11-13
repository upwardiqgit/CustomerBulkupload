package com.example.customerBulkUpload.service;

import com.example.customerBulkUpload.model.Customer;
import com.example.customerBulkUpload.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> searchCustomers(String name, String gender) {
        if (!name.isEmpty() && !gender.isEmpty()) {
            return customerRepository.findByNameContainingIgnoreCaseAndGenderIgnoreCase(name, gender);
        } else if (!name.isEmpty()) {
            return customerRepository.findByNameContainingIgnoreCase(name);
        } else if (!gender.isEmpty()) {
            return customerRepository.findByGenderIgnoreCase(gender);
        } else {
            return customerRepository.findAll();
        }
    }

    public List<Customer> uploadRecords(List<Customer> newCustomers) {
        return customerRepository.saveAll(newCustomers);
    }
}
