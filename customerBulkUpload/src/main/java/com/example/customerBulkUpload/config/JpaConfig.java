package com.example.customerBulkUpload.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.customerBulkUpload.repository")
public class JpaConfig {
}

