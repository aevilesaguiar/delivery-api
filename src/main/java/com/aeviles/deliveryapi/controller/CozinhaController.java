package com.aeviles.deliveryapi.controller;


import com.aeviles.deliveryapi.domain.model.Cozinha;
import com.aeviles.deliveryapi.domain.model.CozinhaXmlWrapper;
import com.aeviles.deliveryapi.domain.repository.CozinhaRepository;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//GET /cozinhas HTTP/1.1
//Response: cozinhaRepository.findAll();

import java.awt.*;
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


        @GetMapping(produces = MediaType.APPLICATION_XML_VALUE) //RESPONDER APENAS QUANDO O CONSUMIDOR PEDIR O FORMATO XML
        public CozinhaXmlWrapper listarXml(){

                //lista umn embrulho do do ObjetoWrapper
                return new CozinhaXmlWrapper(cozinhaRepository.findAll());
        }

        @GetMapping(value = "/{cozinhaId}")// Biding Path variable "cozinhaId" pode ter qualquer outro nome
        public ResponseEntity<Cozinha> findById(@PathVariable Long cozinhaId) { //PathVariable passamos o nome da nossa variavel que queremos fazer um biding

                Cozinha cozinha = cozinhaRepository.findById(cozinhaId);

                if(cozinha != null){ //se a cozinha não está nulo, ou seja existe

                        return ResponseEntity.ok(cozinha);   //retorne a representação da cozinha
                }

                //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                // OU O ATALHO
                return ResponseEntity.notFound().build();  //caso contrário retorne NOTfOUND sem corpo algum

        }


   /*
        @GetMapping(value = "/{cozinhaId}")//Path variable "cozinhaId" pode ter qualquer outro nome
        public Cozinha findId(@PathVariable("cozinhaId") Long id){ //PathVariable passamos o nome da nossa variavel que queremos fazer um biding

                //um print para verificar o erro
                System.out.println("TIPO DE VARIAVEL"+id);
                return cozinhaRepository.findById(id);
        }




         //ao invez de utilizar a Classe cozinha direto eu uso o ResponseEntity
        @GetMapping(value = "/{cozinhaId}")// Biding Path variable "cozinhaId" pode ter qualquer outro nome
        public ResponseEntity<Cozinha> findById(@PathVariable("cozinhaId") Long cozinhaId){ //PathVariable passamos o nome da nossa variavel que queremos fazer um biding

                Cozinha cozinha=cozinhaRepository.findById(cozinhaId);

                //um print para verificar o erro
                System.out.println("TIPO DE VARIAVEL"+cozinhaId);

                //se eu não coloco o body ele não me retorna um payload na volta, ou seja um corpo
               //return ResponseEntity.status(HttpStatus.OK).body(cozinha);

                //o jeito mais simples de uma resposta com sucesso,é um atalho da linha de cima
               return ResponseEntity.ok(cozinha);

                //se eu não quiser um corpo
               // return ResponseEntity.status(HttpStatus.OK).build(); //build constroi um response entity

                //Apenas um exemplo para estudar
                //se eu quisesse retornar um responseEntity - found: quer dizer que esse recurso temporariamente se encontra em outra URI

                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.add(HttpHeaders.LOCATION, "http://api.delivery-api.localhost:8080/cozinhas");//quer dizer que foi  movido temporariamente para esse recursi
                return ResponseEntity
                        .status(HttpStatus.FOUND)
                        .headers(httpHeaders)
                        .build();}*/
        }





