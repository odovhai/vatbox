package com.vatbox.vatboxservice.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private Double amount;

    @Column
    private Double vat;

    @Column
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
