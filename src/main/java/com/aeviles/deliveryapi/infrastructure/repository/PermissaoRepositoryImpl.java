package com.aeviles.deliveryapi.infrastructure.repository;

import com.aeviles.deliveryapi.domain.model.Permissao;
import com.aeviles.deliveryapi.domain.repository.PermissaoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

    @PersistenceContext
    private EntityManager manager; //para obter resultados em JPQL

    @Override
    public List<Permissao> findAll() {
        TypedQuery<Permissao> query = manager.createQuery("from permissao",Permissao.class);

        return query.getResultList();
    }

    @Override
    public Permissao findById(Long id) {


        return manager.find(Permissao.class,id);
    }

    @Transactional
    @Override
    public Permissao adicionar(Permissao permissao) {
        return manager.merge(permissao);
    }

    @Transactional
    @Override
    public void remover(Permissao permissao) {
        permissao=findById(permissao.getId());
        manager.remove(permissao);
    }
}
