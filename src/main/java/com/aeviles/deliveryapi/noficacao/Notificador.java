package com.aeviles.deliveryapi.noficacao;

import com.aeviles.deliveryapi.model.Cliente;
import org.springframework.context.annotation.Bean;

public interface Notificador {

    public void notificar(Cliente cliente, String mensagem);

}
