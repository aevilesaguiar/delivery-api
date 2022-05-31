package com.aeviles.deliveryapi.infrastructure.repository;

import com.aeviles.deliveryapi.domain.model.Estado;
import com.aeviles.deliveryapi.domain.repository.EstadoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
   EntityManager manager;



    @Override
    public List<Estado> findAll() {
        TypedQuery<Estado> query=manager.createQuery("from estado",Estado.class);
        return query.getResultList();
    }

    @Override
    public Estado findById(Long id) {
        return manager.find(Estado.class, id);
    }

    @Transactional
    @Override
    public Estado adicionar(Estado estado) {
        return manager.merge(estado);
    }

    @Override
    public void remover(Estado estado) {

        estado=findById(estado.getId());
        manager.remove(estado);
    }
}
