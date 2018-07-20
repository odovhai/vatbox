package com.vatbox.vatboxservice.service.impl;

import com.vatbox.vatboxservice.domain.dto.report.CustomerTotalReport;
import com.vatbox.vatboxservice.domain.model.Customer;
import com.vatbox.vatboxservice.domain.model.Invoice;
import com.vatbox.vatboxservice.service.CustomerService;
import com.vatbox.vatboxservice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private CustomerService customerService;

    @Override
    @Transactional
    public CustomerTotalReport generateCustomerTotalReport(Long customerId) {
        Customer customer = customerService.findById(customerId);
        double totalAmount = 0.0;
        double totalVat = 0.0;
        for (Invoice invoice : customer.getInvoices()) {
            totalAmount += invoice.getAmount();
            totalVat += invoice.getVat();
        }
        return CustomerTotalReport.builder()
                .customerId(customerId)
                .customerName(customer.getName())
                .totalAmount(totalAmount)
                .totalVat(totalVat)
                .build();
    }

}
