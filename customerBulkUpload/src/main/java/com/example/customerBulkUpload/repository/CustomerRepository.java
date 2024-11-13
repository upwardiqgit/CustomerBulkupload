package com.example.customerBulkUpload.repository;

import com.example.customerBulkUpload.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByNameContainingIgnoreCase(String name);
    List<Customer> findByNameContainingIgnoreCaseAndGenderIgnoreCase(String name, String gender);
    List<Customer> findByGenderIgnoreCase(String gender);
}
