package com.aeviles.deliveryapi;

import com.aeviles.deliveryapi.model.Cliente;
import com.aeviles.deliveryapi.noficacao.Notificador;
import com.aeviles.deliveryapi.noficacao.NotificadorDeEmail;
import com.aeviles.deliveryapi.service.AtivacaoClienteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeliveryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryApiApplication.class, args);

		Cliente cliente1 = new Cliente();
		cliente1.setNome("Joao Pedro");
		cliente1.setEmail("joao@gmail.com");
		cliente1.setTelefone("11 5656-8989");

		Cliente cliente2= new Cliente("Maria Silva", "maria@gmail.com","(11)2323-8989");


		System.out.println("/****************Ativando Clientes**************/");

		//injetando notificador
		Notificador notificador = new NotificadorDeEmail();


		AtivacaoClienteService ativacaoCliente = new AtivacaoClienteService();
		ativacaoCliente.ativar(cliente1);
		ativacaoCliente.ativar(cliente2);



	}

}
