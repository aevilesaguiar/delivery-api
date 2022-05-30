package com.aeviles.deliveryapi.service;

import com.aeviles.deliveryapi.model.Cliente;

public class ClienteAtivadoEvent {

    private Cliente cliente;


    public ClienteAtivadoEvent( Cliente cliente){
        super();
        this.cliente=cliente;
    }

    public Cliente getCliente() {
        return cliente;

    }
}
