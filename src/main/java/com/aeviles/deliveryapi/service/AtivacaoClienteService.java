package com.aeviles.deliveryapi.service;

import com.aeviles.deliveryapi.model.Cliente;
import com.aeviles.deliveryapi.noficacao.NivelUrgencia;
import com.aeviles.deliveryapi.noficacao.Notificador;
import com.aeviles.deliveryapi.noficacao.NotificadorDeEmail;
import com.aeviles.deliveryapi.noficacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AtivacaoClienteService {
    @Autowired(required = false) //eu não teho uma dependencia obrigatório
    //private List< Notificador> notificadores;
    @TipoDoNotificador(NivelUrgencia.URGENTE)
    private  Notificador notificadores;


    public void ativar(Cliente cliente) {
/*
        cliente.ativar();
        for (Notificador notificador:notificadores) {

            notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
        }*/

        System.out.printf("Seu cadastro %s  no sistema está ativo \n", cliente.getNome());


    }
}
