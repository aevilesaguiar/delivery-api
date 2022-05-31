package com.aeviles.deliveryapi.jpa;

import com.aeviles.deliveryapi.DeliveryApiApplication;
import com.aeviles.deliveryapi.domain.model.Estado;
import com.aeviles.deliveryapi.domain.model.Permissao;
import com.aeviles.deliveryapi.domain.repository.EstadoRepository;
import com.aeviles.deliveryapi.domain.repository.PermissaoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaEstadoMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(DeliveryApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);


        List<Estado> estados = estadoRepository.findAll();

        for (Estado estado : estados ) {
            System.out.printf("%s \n",estado.getName());
        }

    }



}