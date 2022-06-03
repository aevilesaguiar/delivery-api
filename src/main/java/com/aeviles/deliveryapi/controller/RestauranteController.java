package com.aeviles.deliveryapi.controller;


import com.aeviles.deliveryapi.domain.exception.EntidadeNaoEncontradaException;
import com.aeviles.deliveryapi.domain.model.Restaurante;
import com.aeviles.deliveryapi.domain.repository.RestauranteRepository;
import com.aeviles.deliveryapi.domain.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //essa anotação é um controlador e possui @Response body
@RequestMapping("/restaurantes")//todas as requisições /restaurantes vão cair nessa requisição
public class RestauranteController {


        @Autowired
        private RestauranteRepository restauranteRepository;

        @Autowired
        private RestauranteService restauranteService;

        @GetMapping
        public List<Restaurante> findAll() {
                return restauranteRepository.findAll();
        }



        @GetMapping(value = "/{restauranteId}")
        public ResponseEntity<Restaurante> findById(@PathVariable Long restauranteId) {
                Restaurante restaurante = restauranteRepository.findById(restauranteId);

                if (restaurante != null) { //se a cozinha não está nulo, ou seja existe

                        return ResponseEntity.ok(restaurante);   //retorne a representação da cozinha
                }

                //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                // OU O ATALHO
                return ResponseEntity.notFound().build();  //caso contrário retorne NOTfOUND sem corpo algum

        }

        //usaremos responseEntity porque iremos customizar as respostas de status http

        @PostMapping
        public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
                try {
                        restaurante = restauranteService.salvar(restaurante);

                        return ResponseEntity.status(HttpStatus.CREATED)
                                .body(restaurante);
                } catch (EntidadeNaoEncontradaException e) {
                        return ResponseEntity.badRequest()
                                .body(e.getMessage());
                }
        }


}


