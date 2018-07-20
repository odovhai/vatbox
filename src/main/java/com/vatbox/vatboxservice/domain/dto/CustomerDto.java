package com.vatbox.vatboxservice.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CustomerDto {

    private Long id;
    @NotEmpty
    private String name;
}
