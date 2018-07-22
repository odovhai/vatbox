package com.vatbox.vatboxservice.service.impl;

import com.vatbox.vatboxservice.domain.dto.report.CustomerTotalReport;
import com.vatbox.vatboxservice.domain.model.Customer;
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
    public CustomerTotalReport generateCustomerTotalReport(Long customerId, Long from, Long to) {
        Customer customer = customerService.findById(customerId);

        final double[] totalAmount = {0.0};
        final double[] totalVat = {0.0};

        customer.getInvoices().stream()
                .filter(invoice -> null == from || invoice.getDate().getTime() >= from)
                .filter(invoice -> null == to || invoice.getDate().getTime() <= to)
                .forEach(invoice -> {
                    totalAmount[0] += invoice.getAmount();
                    totalVat[0] += invoice.getVat();
                });

        return CustomerTotalReport.builder()
                .customerId(customerId)
                .customerName(customer.getName())
                .totalAmount(totalAmount[0])
                .totalVat(totalVat[0])
                .build();
    }

}
