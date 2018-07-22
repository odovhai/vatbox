package com.vatbox.vatboxservice.config;

import com.vatbox.vatboxservice.service.CustomerService;
import com.vatbox.vatboxservice.service.InvoiceService;
import com.vatbox.vatboxservice.service.ReportService;
import com.vatbox.vatboxservice.service.impl.CustomerServiceImpl;
import com.vatbox.vatboxservice.service.impl.InvoiceServiceImpl;
import com.vatbox.vatboxservice.service.impl.ReportServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestsConfig {

    @Bean
    public CustomerService customerService() {
        return new CustomerServiceImpl();
    }

    @Bean
    public InvoiceService invoiceService() {
        return new InvoiceServiceImpl();
    }

    @Bean
    public ReportService reportService() {
        return new ReportServiceImpl();
    }

}
