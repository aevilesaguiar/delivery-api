package com.aeviles.deliveryapi.noficacao;

import com.aeviles.deliveryapi.model.Cliente;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;


@Profile("dev")
@TipoDoNotificador(NivelUrgencia.NORMAL)
@Primary //Bean Principal para fazer a desabiguação
public class NotificadorDeEmailMock implements Notificador {


    public NotificadorDeEmailMock(){
        System.out.println("NotificadorEmail: Mock");
    }
    @Override
    public void notificar(Cliente cliente, String mensagem){
        System.out.printf("MOCK: Notificação seria enviada para  %s através do email %s\n",
                cliente.getNome(), cliente.getEmail(),mensagem);
    }
}
