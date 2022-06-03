package com.aeviles.deliveryapi.domain.service;


//regras de negócios de cadastro da cozinha


import com.aeviles.deliveryapi.domain.exception.EntidadeEmUsoException;
import com.aeviles.deliveryapi.domain.exception.EntidadeNaoEncontradaException;
import com.aeviles.deliveryapi.domain.model.Cozinha;
import com.aeviles.deliveryapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CozinhaService {
    @Autowired
    private CozinhaRepository cozinhaRepository;


    //classe de serviço não conece o protocolo http

    //delegando apenas para o repositorio
    //Mas poderia ter uma regra de negócio
    //Não mexeria mais no controller , só aqui
    public Cozinha salvar(Cozinha cozinha){
        return cozinhaRepository.salvar(cozinha);
    }

    public void remover(Long cozinhaId){
        try {
            cozinhaRepository.remover(cozinhaId);
        }catch (EmptyResultDataAccessException e){
            throw  new EntidadeNaoEncontradaException( String.format("Não existe um cadastro de cozinha com código %d",cozinhaId));
        }
        catch (DataIntegrityViolationException e){//quando o recurso não pode ser excluido
            throw new EntidadeEmUsoException(String.format("Cozinha de código %d não pode ser removida, pois está em uso", cozinhaId));

            }
        }
    }







