package com.vatbox.vatboxservice.controller;

import com.vatbox.vatboxservice.domain.model.Customer;
import com.vatbox.vatboxservice.service.CustomerService;
import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Api
@RestController
@RequestMapping("/api/v1")
public class TestController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping(@RequestParam(required = false) String str) {
        return "pong";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public List<Customer> getCustomers(@RequestBody(required = false) @Valid Dto dto) {
        return customerService.findAll();
    }

    @Data
    public static class Dto {
        @NotEmpty
        private String str;
    }

}
