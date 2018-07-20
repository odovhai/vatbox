package com.vatbox.vatboxservice.service;

import com.vatbox.vatboxservice.domain.model.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> findAll();

    List<Invoice> findByCustomerId(Long customerId);

    Invoice findById(Long id);

    Invoice save(Invoice invoice);

    Invoice update(Invoice invoice);

    void delete(Long id);
}
