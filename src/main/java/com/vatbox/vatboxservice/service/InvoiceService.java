package com.vatbox.vatboxservice.service;

import com.vatbox.vatboxservice.domain.model.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> findAll();

    Invoice save(Invoice customer);
}
