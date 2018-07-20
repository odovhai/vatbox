package com.vatbox.vatboxservice.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotEmpty
    private String name;

    @Column
    @NotNull
    private Double amount;

    @Column
    @NotNull
    private Double vat;

    @Column
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
