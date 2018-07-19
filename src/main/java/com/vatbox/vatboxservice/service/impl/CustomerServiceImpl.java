package com.vatbox.vatboxservice.service.impl;

import com.vatbox.vatboxservice.domain.model.Customer;
import com.vatbox.vatboxservice.domain.repository.CustomerRepository;
import com.vatbox.vatboxservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }
}
