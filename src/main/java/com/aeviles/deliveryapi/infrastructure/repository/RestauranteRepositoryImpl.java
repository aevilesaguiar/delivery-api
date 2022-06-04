package com.aeviles.deliveryapi.infrastructure.repository;

import com.aeviles.deliveryapi.domain.model.Restaurante;
import com.aeviles.deliveryapi.domain.repository.RestauranteRepository;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public Restaurante salvar(Restaurante restaurante) {

        return manager.merge(restaurante); //
    }
    @Transactional
    @Override
    public void remover(Long restauranteId) {
      Restaurante restaurante= findById(restauranteId);

      if(restaurante==null){
          //senão encontrar pelo o menos 1
          throw new EmptyResultDataAccessException(1);
      }

      manager.remove(restaurante);

    }

    @Override
    public Restaurante findById(Long id) {

        return manager.find(Restaurante.class, id);
    }








}


