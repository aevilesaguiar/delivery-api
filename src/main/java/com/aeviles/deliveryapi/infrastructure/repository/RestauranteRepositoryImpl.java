package com.aeviles.deliveryapi.infrastructure.repository;

import com.aeviles.deliveryapi.domain.model.Cozinha;
import com.aeviles.deliveryapi.domain.model.Restaurante;
import com.aeviles.deliveryapi.domain.repository.CozinhaRepository;
import com.aeviles.deliveryapi.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> findAll() {
        TypedQuery<Restaurante> query = manager.createQuery("from restaurante", Restaurante.class);

        return query.getResultList();


    }

    @Override
    @Transactional//quando eu anoto um método com transactional esse método vai ser executado dentro de uma transação
    public Restaurante adicionar(Restaurante restaurante) {

        return manager.merge(restaurante); //
    }

    @Override
    public Restaurante findById(Long id) {

        return manager.find(Restaurante.class, id);
    }

    @Override
    @Transactional //para ele ser executado dentro de uma transação
    public void remover(Restaurante restaurante) {
        restaurante = findById(restaurante.getId()); //isso é um find
        manager.remove(restaurante);

    }

}


