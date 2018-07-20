package com.vatbox.vatboxservice.controller;

import com.vatbox.vatboxservice.common.converter.EntityDtoConverter;
import com.vatbox.vatboxservice.domain.dto.CustomerDto;
import com.vatbox.vatboxservice.domain.model.Customer;
import com.vatbox.vatboxservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;
    @Autowired
    private EntityDtoConverter<Customer, CustomerDto> converter;


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public CustomerDto save(@RequestBody @Valid CustomerDto customer) {
        Customer saved = customerService.save(converter.toEntity(customer));
        return converter.toDto(saved);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<CustomerDto> getAll() {
        return converter.toDtoList(customerService.findAll());

    }

}
