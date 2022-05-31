package com.aeviles.deliveryapi.infrastructure.repository;

import com.aeviles.deliveryapi.domain.model.FormaPagamento;
import com.aeviles.deliveryapi.domain.repository.FormaPagamentoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {


    @PersistenceContext
    private EntityManager manager; //EntityManager interface que possui vários métodos

    @Override
    public List<FormaPagamento> findAll() {

       //Interface TypedQueryJá possui vários métodos prontos
        TypedQuery<FormaPagamento> query = manager.createQuery("from forma_pagamento", FormaPagamento.class);
        return query.getResultList();
    }

    @Override
    public FormaPagamento findById(Long id) {

        return manager.find(FormaPagamento.class, id);
    }

    @Override
    @Transactional //metoso vai executar dentro de uma transação
    public FormaPagamento adicionar(FormaPagamento formaPagamento) {

        return manager.merge(formaPagamento);
    }

    @Override
    @Transactional//executado dentro de uma transação
    public void remover(FormaPagamento formaPagamento) {

        formaPagamento=findById(formaPagamento.getId());
        manager.remove(formaPagamento);
    }
}
