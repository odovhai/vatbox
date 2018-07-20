package com.vatbox.vatboxservice.service.impl;

import com.vatbox.vatboxservice.common.exception.NotFoundException;
import com.vatbox.vatboxservice.domain.model.Customer;
import com.vatbox.vatboxservice.repository.CustomerRepository;
import com.vatbox.vatboxservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = repository.findAll();
        if (CollectionUtils.isEmpty(customers)) {
            throw new NotFoundException("No customers found.");
        }
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        return findCustomerById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        Long customerId = customer.getId();
        Customer customerToUpdate = findCustomerById(customerId);
        customerToUpdate.setName(customer.getName());
        return repository.save(customerToUpdate);
    }

    @Override
    public void delete(Long id) {
        Customer customerToDelete = findCustomerById(id);
        repository.delete(customerToDelete);
    }

    private Customer findCustomerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer with id=[" + id + "] not found."));
    }
}
