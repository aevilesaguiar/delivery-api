package com.aeviles.deliveryapi.domain.repository;

import com.aeviles.deliveryapi.domain.model.Restaurante;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RestauranteRepository {

    List<Restaurante> findAll();

    Restaurante findById(Long id);

    Restaurante salvar(Restaurante restaurante);

    void remover(Long id);
}
