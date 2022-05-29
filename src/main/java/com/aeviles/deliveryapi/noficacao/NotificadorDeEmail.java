package com.aeviles.deliveryapi.noficacao;

import com.aeviles.deliveryapi.model.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Qualifier("urgente")
@TipoDoNotificador(NivelUrgencia.NORMAL)
@Primary //Bean Principal para fazer a desabiguação
public class NotificadorDeEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem){
        System.out.printf("Notificando %s através do email %s\n",
                cliente.getNome(), cliente.getEmail(),mensagem);
    }
}
