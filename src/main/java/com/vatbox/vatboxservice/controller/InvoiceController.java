package com.vatbox.vatboxservice.controller;

import com.vatbox.vatboxservice.common.converter.EntityDtoConverter;
import com.vatbox.vatboxservice.domain.dto.InvoiceDto;
import com.vatbox.vatboxservice.domain.model.Invoice;
import com.vatbox.vatboxservice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private EntityDtoConverter<Invoice, InvoiceDto> converter;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public InvoiceDto save(@RequestBody @Valid InvoiceDto invoice) {
        Invoice saved = invoiceService.save(converter.toEntity(invoice));
        return converter.toDto(saved);
    }

}
