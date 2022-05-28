package com.aeviles.deliveryapi.noficacao;

import com.aeviles.deliveryapi.model.Cliente;

public interface Notificador {

    public void notificar(Cliente cliente, String mensagem);

}
