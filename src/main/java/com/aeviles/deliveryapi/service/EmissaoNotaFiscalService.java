package com.aeviles.deliveryapi.service;

import com.aeviles.deliveryapi.model.Cliente;
import com.aeviles.deliveryapi.model.Produto;
import com.aeviles.deliveryapi.noficacao.NotificadorDeEmail;

public class EmissaoNotaFiscalService {
    public void emitir(Cliente cliente, Produto produto){
        //TODO simula a emissão do nf..

        NotificadorDeEmail notificar = new NotificadorDeEmail();
        notificar.notificar(cliente, "Nota fiscal do Produto"
                + produto.getNome() + " foi emitida! ");
    }

}
