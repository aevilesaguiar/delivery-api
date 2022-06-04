package com.aeviles.deliveryapi.domain.repository;

import com.aeviles.deliveryapi.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {

    List<Cidade> findAll();

    Cidade findById(Long id);

    Cidade salvar(Cidade cidade);

    void remover(Long id);



}
