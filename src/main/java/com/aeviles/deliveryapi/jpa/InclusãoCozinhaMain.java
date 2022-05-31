package com.aeviles.deliveryapi.jpa;

import com.aeviles.deliveryapi.DeliveryApiApplication;
import com.aeviles.deliveryapi.domain.model.Cozinha;
import com.aeviles.deliveryapi.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusãoCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(DeliveryApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);

      Cozinha cozinha1 = new Cozinha();
      cozinha1.setNome("Brasileira");


        Cozinha cozinha2 = new Cozinha();
        cozinha2.setNome("Japonesa");

        cozinha1= cadastroCozinha.adicionar(cozinha1);
        cozinha2=cadastroCozinha.adicionar(cozinha2);

        System.out.printf("%d - %s\n",cozinha1.getId(), cozinha1.getNome());
        System.out.printf("%d - %s\n",cozinha2.getId(), cozinha2.getNome());

    }



}