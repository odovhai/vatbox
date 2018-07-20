package com.vatbox.vatboxservice.controller;

import com.vatbox.vatboxservice.domain.dto.report.CustomerTotalReport;
import com.vatbox.vatboxservice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;


    @RequestMapping(value = "/total/customer/{id}", method = RequestMethod.GET)
    public CustomerTotalReport generateCustomerTotalReport(@PathVariable Long id) {
        return reportService.generateCustomerTotalReport(id);
    }
}
