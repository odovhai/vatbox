package com.vatbox.vatboxservice.controller;

import com.vatbox.vatboxservice.domain.dto.report.CustomerTotalReport;
import com.vatbox.vatboxservice.service.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reports")
@Api(value = "Reports", description = "Generating reports")
public class ReportController {

    @Autowired
    private ReportService reportService;


    @ApiOperation(value = "Generate report with total amount and total VAT for given customer")
    @RequestMapping(value = "/total/customer/{id}", method = RequestMethod.GET)
    public CustomerTotalReport generateCustomerTotalReport(
            @ApiParam(value = "the customer id", required = true)
            @PathVariable Long id,

            @ApiParam(value = "timestamp of date for filtering from")
            @RequestParam(required = false) Long from,

            @ApiParam(value = "timestamp of date for filtering to")
            @RequestParam(required = false) Long to) {
        return reportService.generateCustomerTotalReport(id, from, to);
    }
}
