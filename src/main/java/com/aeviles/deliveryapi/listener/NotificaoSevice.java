package com.aeviles.deliveryapi.listener;

import com.aeviles.deliveryapi.model.Cliente;
import com.aeviles.deliveryapi.noficacao.NivelUrgencia;
import com.aeviles.deliveryapi.noficacao.Notificador;
import com.aeviles.deliveryapi.noficacao.TipoDoNotificador;
import com.aeviles.deliveryapi.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificaoSevice {


    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo!");
    }
}
