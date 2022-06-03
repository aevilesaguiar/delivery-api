package com.aeviles.deliveryapi.domain.exception;

public class EntidadeEmUsoException extends RuntimeException{

    private static final long serialVersionUID=1L;


    //construtor que recebe uma mensagem
    public EntidadeEmUsoException(String mensagem){
        super(mensagem);
    }


}
