package com.aeviles.deliveryapi.jpa;

import com.aeviles.deliveryapi.DeliveryApiApplication;
import com.aeviles.deliveryapi.domain.model.Cozinha;
import com.aeviles.deliveryapi.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteracaoCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(DeliveryApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);

      Cozinha cozinha = new Cozinha();
      cozinha.setId(1L);
      cozinha.setNome("Brasilena");



        cozinha= cadastroCozinha.salvar(cozinha);


        System.out.printf("%d - %s\n",cozinha.getId(), cozinha.getNome());


    }



}