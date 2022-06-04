package com.aeviles.deliveryapi.domain.repository;

import com.aeviles.deliveryapi.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> findAll();

    Estado findById(Long id);

    Estado adicionar(Estado estado);

    void remover(Long id);




}
