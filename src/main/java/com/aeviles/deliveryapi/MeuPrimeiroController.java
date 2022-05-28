package com.aeviles.deliveryapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {

       @GetMapping("/hello")  //http://localhost:8080/hello
       @ResponseBody//quer dizer que eu quero  que o retorno nesse caso a String seja devolvida como resposta dessa requisição
        public String hello(){
            return "Olá Mundo, belo e grande";
        }

}
