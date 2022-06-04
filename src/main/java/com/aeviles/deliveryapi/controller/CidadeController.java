package com.aeviles.deliveryapi.controller;
import com.aeviles.deliveryapi.domain.exception.EntidadeEmUsoException;
import com.aeviles.deliveryapi.domain.exception.EntidadeNaoEncontradaException;
import com.aeviles.deliveryapi.domain.model.Cidade;
import com.aeviles.deliveryapi.domain.repository.CidadeRepository;
import com.aeviles.deliveryapi.domain.repository.EstadoRepository;
import com.aeviles.deliveryapi.domain.service.CidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public List<Cidade> findAll(){
        return cidadeRepository.findAll();
    }

    @GetMapping(value = "/{cidadeId}")
    public ResponseEntity<Cidade> findById(@PathVariable Long cidadeId){
        Cidade cidade=cidadeRepository.findById(cidadeId);

        if(cidade!= null){
            return ResponseEntity.ok(cidade);
        }
        return ResponseEntity.notFound().build(); //404
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Cidade cidade) {
        try {
            cidade = cidadeService.salvar(cidade);

            return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.badRequest().body(e.getMessage()); //tenho que tirar o tipo e incluir um corriga devido essa exceção
        }

    }

    @PutMapping(value = "/{cidadeId}")
    public ResponseEntity<?> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade){

        try {
            Cidade cidadeAtual = cidadeRepository.findById(cidadeId);
            if(cidade != null){
                BeanUtils.copyProperties(cidade, cidadeAtual,"id");
                cidadeAtual=cidadeRepository.salvar(cidadeAtual);

                return ResponseEntity.ok(cidadeAtual);
            }

            return ResponseEntity.notFound().build();

        }catch (EntidadeNaoEncontradaException e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }


    }

    @DeleteMapping(value = "/{cidadeId}")
    public ResponseEntity <Cidade> deletar( @PathVariable Long cidadeId ){

        try {
            cidadeService.remover(cidadeId);
            return ResponseEntity.noContent().build();
        }
        catch (EntidadeNaoEncontradaException e){

            return ResponseEntity.notFound().build();
        }
        catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

}




