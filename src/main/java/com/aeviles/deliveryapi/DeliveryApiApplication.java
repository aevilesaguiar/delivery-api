package com.aeviles.deliveryapi;

import com.aeviles.deliveryapi.model.Cliente;
import com.aeviles.deliveryapi.noficacao.Notificador;
import com.aeviles.deliveryapi.noficacao.NotificadorDeEmail;
import com.aeviles.deliveryapi.noficacao.NotificadorDeEmailMock;
import com.aeviles.deliveryapi.service.AtivacaoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeliveryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryApiApplication.class, args);




	}

}
