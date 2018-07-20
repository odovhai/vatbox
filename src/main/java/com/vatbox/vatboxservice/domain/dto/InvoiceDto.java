package com.vatbox.vatboxservice.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class InvoiceDto {

    private Long id;
    @NotNull
    private Long customerId;
    @NotEmpty
    private String name;
    @NotNull
    private Double amount;
    @NotNull
    private Double vat;
    private Date date;
}
