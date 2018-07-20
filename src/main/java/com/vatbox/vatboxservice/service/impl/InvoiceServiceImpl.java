package com.vatbox.vatboxservice.service.impl;

import com.google.common.base.Preconditions;
import com.vatbox.vatboxservice.common.exception.NotFoundException;
import com.vatbox.vatboxservice.domain.model.Invoice;
import com.vatbox.vatboxservice.repository.CustomerRepository;
import com.vatbox.vatboxservice.repository.InvoiceRepository;
import com.vatbox.vatboxservice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public List<Invoice> findByCustomerId(Long customerId) {
        List<Invoice> invoices = invoiceRepository.findInvoicesByCustomerId(customerId);
        if (CollectionUtils.isEmpty(invoices)) {
            throw new NotFoundException(String.format("Invoices for customerId=[%d] not found", customerId));
        }
        return invoices;
    }

    @Override
    public Invoice findById(Long id) {
        return findInvoiceById(id);
    }

    @Override
    public Invoice save(Invoice invoice) {
        Long customerId = invoice.getCustomer().getId();
        Preconditions.checkState(customerRepository.findById(customerId).isPresent(), "Customer with id=[" + customerId + "] does not exist.");
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice update(Invoice invoice) {
        Long invoiceId = invoice.getId();
        Invoice invoiceToUpdate = findInvoiceById(invoiceId);
        invoiceToUpdate.setName(invoice.getName());
        invoiceToUpdate.setAmount(invoice.getAmount());
        invoiceToUpdate.setVat(invoice.getVat());
        invoiceToUpdate.setDate(invoice.getDate());
        invoiceToUpdate.setCustomer(invoice.getCustomer());
        return save(invoiceToUpdate);
    }

    @Override
    public void delete(Long id) {
        Invoice invoiceToDelete = findInvoiceById(id);
        invoiceRepository.delete(invoiceToDelete);
    }

    private Invoice findInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Invoice with id=[" + id + "] not found."));
    }
}
