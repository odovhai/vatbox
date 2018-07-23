package com.vatbox.vatboxservice.common.converter.impl;

import com.vatbox.vatboxservice.common.converter.EntityDtoConverter;
import lombok.AllArgsConstructor;
import org.dozer.DozerBeanMapper;

@AllArgsConstructor
public class DefaultDozerEntityDtoConverter<E, D> implements EntityDtoConverter<E, D> {

    private final static DozerBeanMapper MAPPER = new DozerBeanMapper();

    private Class<E> entityClass;
    private Class<D> dtoClass;

    @Override
    public D toDto(E source) {
        return MAPPER.map(source, dtoClass);
    }

    @Override
    public E toEntity(D source) {
        return MAPPER.map(source, entityClass);
    }

}
