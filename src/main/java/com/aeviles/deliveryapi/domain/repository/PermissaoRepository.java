package com.aeviles.deliveryapi.domain.repository;

import com.aeviles.deliveryapi.domain.model.Permissao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissaoRepository {

    List<Permissao> findAll();

    Permissao findById (Long id);

    Permissao adicionar(Permissao permissao);

    void remover(Permissao permissao);



}
