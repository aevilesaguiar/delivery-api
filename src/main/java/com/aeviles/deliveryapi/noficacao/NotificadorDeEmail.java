package com.aeviles.deliveryapi.noficacao;

import com.aeviles.deliveryapi.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev") //esse profile requer um nome, esse componente notificador vai ser registrado apenas se estiver rodando no ambiente "prod"
@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorDeEmail implements Notificador {
    @Autowired
    private NotificadorProperties notificadorProperties;
    public NotificadorDeEmail(){
        System.out.println("NotificadorEmail: Real");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem){

        System.out.println("Host: "+notificadorProperties.getHostServidor());
        System.out.println("Porta: "+notificadorProperties.getPortaServidor());

        System.out.printf("Notificando %s através do email %s\n",
                cliente.getNome(), cliente.getEmail(),mensagem);
    }
}
