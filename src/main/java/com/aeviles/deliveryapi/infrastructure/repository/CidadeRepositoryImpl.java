package com.aeviles.deliveryapi.infrastructure.repository;

import com.aeviles.deliveryapi.domain.model.Cidade;
import com.aeviles.deliveryapi.domain.repository.CidadeRepository;
import com.aeviles.deliveryapi.domain.repository.EstadoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

    @PersistenceContext
   EntityManager manager;



    @Override
    public List<Cidade> findAll() {
        TypedQuery<Cidade> query=manager.createQuery("from cidade",Cidade.class);
        return query.getResultList();
    }

    @Override
    public Cidade findById(Long id) {
        return manager.find(Cidade.class, id);
    }

    @Transactional
    @Override
    public Cidade adicionar(Cidade cidade) {
        return manager.merge(cidade);
    }

    @Override
    public void remover(Cidade cidade) {

        cidade=findById(cidade.getId());
        manager.remove(cidade);
    }
}
