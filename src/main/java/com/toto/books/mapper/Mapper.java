package com.toto.books.mapper;

public interface Mapper<E, D> {

    D toDTO(E entity);

    E toEntity(D dto);
    
}