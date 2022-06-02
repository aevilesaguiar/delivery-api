package com.aeviles.deliveryapi.domain.exception;

import org.springframework.dao.EmptyResultDataAccessException;

public class EntidadeNaoEncontradaException extends RuntimeException {

    private static final long serialVersionUID=1L;

    public EntidadeNaoEncontradaException(String mensagem){
        super(mensagem);
    }

}
