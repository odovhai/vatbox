package com.vatbox.vatboxservice.domain.model;

import com.google.common.collect.Lists;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoices = Lists.newArrayList();
}
