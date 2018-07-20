package com.vatbox.vatboxservice.common.converter.impl;

import com.vatbox.vatboxservice.domain.dto.InvoiceDto;
import com.vatbox.vatboxservice.domain.model.Customer;
import com.vatbox.vatboxservice.domain.model.Invoice;

import java.util.Date;

public class InvoiceConverter extends DefaultDozerEntityDtoConverter<Invoice, InvoiceDto> {

    public InvoiceConverter() {
        super(Invoice.class, InvoiceDto.class);
    }

    @Override
    public Invoice toEntity(InvoiceDto dto) {
        Invoice invoice = super.toEntity(dto);
        Customer customer = new Customer();
        customer.setId(dto.getCustomerId());
        invoice.setCustomer(customer);
        if (null == invoice.getDate()) {
            invoice.setDate(new Date());
        }
        return invoice;
    }
}