package com.vatbox.vatboxservice.service;

import com.vatbox.vatboxservice.domain.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer save(Customer customer);
}
