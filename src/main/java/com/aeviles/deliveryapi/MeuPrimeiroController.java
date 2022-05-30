package com.aeviles.deliveryapi;

import com.aeviles.deliveryapi.model.Cliente;
import com.aeviles.deliveryapi.service.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {


    private AtivacaoClienteService ativacaoClienteService;

    public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;
    }


       @GetMapping("/hello")  //http://localhost:8080/hello
       @ResponseBody//quer dizer que eu quero  que o retorno nesse caso a String seja devolvida como resposta dessa requisição
        public String hello(){
           Cliente nome = new Cliente("Pedro", "pedro@gmail.com", "3212356989989");

           ativacaoClienteService.ativar(nome);

           return "Hello!";
       }

        }


