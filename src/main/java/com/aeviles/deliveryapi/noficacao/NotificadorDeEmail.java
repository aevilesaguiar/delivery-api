package com.aeviles.deliveryapi.noficacao;

import com.aeviles.deliveryapi.model.Cliente;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev") //esse profile requer um nome, esse componente notificador vai ser registrado apenas se estiver rodando no ambiente "prod"
@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorDeEmail implements Notificador {

    public NotificadorDeEmail(){
        System.out.println("NotificadorEmail: Real");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem){

        System.out.printf("Notificando %s através do email %s\n",
                cliente.getNome(), cliente.getEmail(),mensagem);
    }
}
