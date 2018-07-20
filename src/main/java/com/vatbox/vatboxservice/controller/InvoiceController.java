package com.vatbox.vatboxservice.controller;

import com.vatbox.vatboxservice.common.converter.EntityDtoConverter;
import com.vatbox.vatboxservice.domain.dto.InvoiceDto;
import com.vatbox.vatboxservice.domain.model.Invoice;
import com.vatbox.vatboxservice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private EntityDtoConverter<Invoice, InvoiceDto> converter;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<InvoiceDto> getAll() {
        return converter.toDtoList(invoiceService.findAll());
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public List<InvoiceDto> getForCustomer(@PathVariable Long id) {
        return converter.toDtoList(invoiceService.findByCustomerId(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public InvoiceDto save(@RequestBody @Valid InvoiceDto invoice) {
        Invoice saved = invoiceService.save(converter.toEntity(invoice));
        return converter.toDto(saved);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public InvoiceDto update(@RequestBody @Valid InvoiceDto invoice) {
        Invoice updated = invoiceService.update(converter.toEntity(invoice));
        return converter.toDto(updated);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public InvoiceDto get(@PathVariable Long id) {
        return converter.toDto(invoiceService.findById(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        invoiceService.delete(id);
    }


}
