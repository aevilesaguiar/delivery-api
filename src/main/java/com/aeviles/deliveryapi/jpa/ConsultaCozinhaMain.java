package com.aeviles.deliveryapi.jpa;

import com.aeviles.deliveryapi.DeliveryApiApplication;
import com.aeviles.deliveryapi.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.aeviles.deliveryapi.domain.model.Cozinha;


import java.util.List;

public class ConsultaCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(DeliveryApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);


        List<Cozinha> cozinha = cadastroCozinha.findAll();

        for (Cozinha cozinhas : cozinha) {
            System.out.println(cozinhas.getNome());
        }

    }



}