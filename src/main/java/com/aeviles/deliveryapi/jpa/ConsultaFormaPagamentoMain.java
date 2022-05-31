package com.aeviles.deliveryapi.jpa;

import com.aeviles.deliveryapi.DeliveryApiApplication;
import com.aeviles.deliveryapi.domain.model.FormaPagamento;
import com.aeviles.deliveryapi.domain.model.Restaurante;
import com.aeviles.deliveryapi.domain.repository.FormaPagamentoRepository;
import com.aeviles.deliveryapi.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaFormaPagamentoMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(DeliveryApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);


        List<FormaPagamento> formaPagamentos = formaPagamentoRepository.findAll();

        for (FormaPagamento formaPagamento : formaPagamentos ) {
            System.out.printf("%s \n",formaPagamento.getDescricao());
        }

    }



}