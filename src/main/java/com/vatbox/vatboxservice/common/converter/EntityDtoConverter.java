package com.vatbox.vatboxservice.common.converter;

import java.util.List;

public interface EntityDtoConverter<E, D> {

    D toDto(E source);
    List<D> toDtoList(List<E> source);
    E toEntity(D source);
    List<E> toEntityList(List<D> source);

}
