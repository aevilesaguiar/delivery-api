package com.aeviles.deliveryapi.noficacao;

import com.aeviles.deliveryapi.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class NotificadorDeEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem){
        System.out.printf("Notificando %s através do email %s\n",
                cliente.getNome(), cliente.getEmail(),mensagem);
    }
}
