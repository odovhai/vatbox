package com.vatbox.vatboxservice.domain.dto.report;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerTotalReport {
    private Long customerId;
    private String customerName;
    private double totalAmount;
    private double totalVat;
}
