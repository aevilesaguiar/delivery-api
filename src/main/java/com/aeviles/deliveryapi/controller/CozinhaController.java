package com.aeviles.deliveryapi.controller;


import com.aeviles.deliveryapi.domain.model.Cozinha;
import com.aeviles.deliveryapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//GET /cozinhas HTTP/1.1
//Response: cozinhaRepository.findAll();

import java.util.List;

@RestController //essa anotação é um controlador e possui @Response body
@RequestMapping("/cozinhas")//todas as requisições /cozinhas vai cair nessa requisição
public class CozinhaController {


        @Autowired
        private CozinhaRepository cozinhaRepository;

        @GetMapping
        public List<Cozinha>  findAll(){
            return cozinhaRepository.findAll();
        }


}
