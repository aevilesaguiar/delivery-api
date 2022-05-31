package com.aeviles.deliveryapi.jpa;

import com.aeviles.deliveryapi.DeliveryApiApplication;
import com.aeviles.deliveryapi.domain.model.FormaPagamento;
import com.aeviles.deliveryapi.domain.model.Permissao;
import com.aeviles.deliveryapi.domain.repository.FormaPagamentoRepository;
import com.aeviles.deliveryapi.domain.repository.PermissaoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaPermissaoMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(DeliveryApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);


        List<Permissao> permissoes = permissaoRepository.findAll();

        for (Permissao permissao : permissoes ) {
            System.out.printf("%s \n",permissao.getDescricao());
        }

    }



}