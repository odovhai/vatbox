package com.vatbox.vatboxservice.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
}
