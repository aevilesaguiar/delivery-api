package com.aeviles.deliveryapi.domain.repository;

import com.aeviles.deliveryapi.domain.model.FormaPagamento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormaPagamentoRepository {

    List<FormaPagamento> findAll();

    FormaPagamento findById(Long id);

    FormaPagamento adicionar(FormaPagamento formaPagamento);

    void remover(FormaPagamento formaPagamento);


}
