package com.vatbox.vatboxservice;

import com.google.common.collect.Lists;
import com.vatbox.vatboxservice.config.TestsConfig;
import com.vatbox.vatboxservice.domain.dto.report.CustomerTotalReport;
import com.vatbox.vatboxservice.domain.model.Customer;
import com.vatbox.vatboxservice.domain.model.Invoice;
import com.vatbox.vatboxservice.repository.CustomerRepository;
import com.vatbox.vatboxservice.service.ReportService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {TestsConfig.class, VatboxServiceApplication.class})
@EnableAutoConfiguration
public class CustomerTotalReportTest {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ReportService reportService;

    public static final long[] TEST_DATES = {1530000000L, 1531000000L, 1532000000L};

    @Before
    public void initDatabase() {
        Customer customer1 = new Customer();
        customer1.setName("Oleh");
        Customer dupCustomer1 = new Customer();
        dupCustomer1.setId(1L);
        Invoice inv1 = Invoice.builder()
                .amount(111.11)
                .vat(11.11)
                .name("Inv1")
                .customer(dupCustomer1)
                .date(new Date(TEST_DATES[0]))
                .build();
        Invoice inv2 = Invoice.builder()
                .amount(333.22)
                .vat(33.22)
                .name("Inv2")
                .customer(dupCustomer1)
                .date(new Date(TEST_DATES[1]))
                .build();
        Invoice inv3 = Invoice.builder()
                .amount(222.33)
                .vat(22.33)
                .name("Inv3")
                .customer(dupCustomer1)
                .date(new Date(TEST_DATES[2]))
                .build();

        customer1.setInvoices(Lists.newArrayList(inv1, inv2, inv3));

        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setName("Sasha");
        Customer dupCustomer2 = new Customer();
        dupCustomer2.setId(2L);
        Invoice act1 = Invoice.builder()
                .amount(111.11)
                .vat(11.11)
                .name("Act1")
                .customer(dupCustomer2)
                .date(new Date(TEST_DATES[0]))
                .build();
        Invoice act2 = Invoice.builder()
                .amount(222.22)
                .vat(22.22)
                .name("Act2")
                .customer(dupCustomer2)
                .date(new Date(TEST_DATES[1]))
                .build();
        customer2.setInvoices(Lists.newArrayList(act1, act2));
        customerRepository.save(customer2);
    }

    @Test
    public void testTotalReportWithFilter() {

        CustomerTotalReport reportNoFilter = reportService.generateCustomerTotalReport(2L, null, null);
        Assert.assertEquals(333.33, reportNoFilter.getTotalAmount(), 0.0001);
        Assert.assertEquals(33.33, reportNoFilter.getTotalVat(), 0.0001);

        CustomerTotalReport reportFromToFilter = reportService.generateCustomerTotalReport(1L, TEST_DATES[0], TEST_DATES[1]);
        Assert.assertEquals(444.33, reportFromToFilter.getTotalAmount(), 0.0001);
        Assert.assertEquals(44.33, reportFromToFilter.getTotalVat(), 0.0001);

        CustomerTotalReport reportFromFilter = reportService.generateCustomerTotalReport(1L, TEST_DATES[1], null);
        Assert.assertEquals(555.55, reportFromFilter.getTotalAmount(), 0.0001);
        Assert.assertEquals(55.55, reportFromFilter.getTotalVat(), 0.0001);

        CustomerTotalReport reportToFilter = reportService.generateCustomerTotalReport(1L, null, TEST_DATES[2] - 1);
        Assert.assertEquals(444.33, reportToFilter.getTotalAmount(), 0.0001);
        Assert.assertEquals(44.33, reportToFilter.getTotalVat(), 0.0001);

    }

}
