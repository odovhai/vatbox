package com.vatbox.vatboxservice.service;

import com.vatbox.vatboxservice.domain.dto.report.CustomerTotalReport;

public interface ReportService {

    CustomerTotalReport generateCustomerTotalReport(Long customerId);
}
