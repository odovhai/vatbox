package com.vatbox.vatboxservice.service.impl;

import com.vatbox.vatboxservice.domain.model.Invoice;
import com.vatbox.vatboxservice.repository.InvoiceRepository;
import com.vatbox.vatboxservice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository repository;

    @Override
    public List<Invoice> findAll() {
        return repository.findAll();
    }

    @Override
    public Invoice save(Invoice invoice) {
        return repository.save(invoice);
    }
}
