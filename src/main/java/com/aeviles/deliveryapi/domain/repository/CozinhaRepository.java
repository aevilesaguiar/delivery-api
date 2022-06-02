package com.aeviles.deliveryapi.domain.repository;

import com.aeviles.deliveryapi.domain.model.Cozinha;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinhaRepository {

    List<Cozinha> findAll();

    Cozinha findById(Long id);

    Cozinha salvar(Cozinha cozinha );

    void remover(Long id);






}
