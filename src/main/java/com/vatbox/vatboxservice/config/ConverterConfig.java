package com.vatbox.vatboxservice.config;

import com.vatbox.vatboxservice.common.converter.EntityDtoConverter;
import com.vatbox.vatboxservice.common.converter.impl.DefaultDozerEntityDtoConverter;
import com.vatbox.vatboxservice.common.converter.impl.InvoiceConverter;
import com.vatbox.vatboxservice.domain.dto.CustomerDto;
import com.vatbox.vatboxservice.domain.dto.InvoiceDto;
import com.vatbox.vatboxservice.domain.model.Customer;
import com.vatbox.vatboxservice.domain.model.Invoice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfig {

    @Bean
    public EntityDtoConverter<Customer, CustomerDto> customerConverter() {
        return new DefaultDozerEntityDtoConverter<>(Customer.class, CustomerDto.class);
    }

    @Bean
    public EntityDtoConverter<Invoice, InvoiceDto> invoiceConverter() {
        return new InvoiceConverter();
    }
}
