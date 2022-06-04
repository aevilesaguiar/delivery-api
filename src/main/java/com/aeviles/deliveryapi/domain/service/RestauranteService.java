package com.aeviles.deliveryapi.domain.service;


//regras de negócios de cadastro da cozinha


import com.aeviles.deliveryapi.domain.exception.EntidadeEmUsoException;
import com.aeviles.deliveryapi.domain.exception.EntidadeNaoEncontradaException;
import com.aeviles.deliveryapi.domain.model.Cozinha;
import com.aeviles.deliveryapi.domain.model.Restaurante;
import com.aeviles.deliveryapi.domain.repository.CozinhaRepository;
import com.aeviles.deliveryapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private  CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {

        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.findById(cozinhaId);

        //se a cozinha não existir lança uma exception
        if(cozinha == null){
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de cozinha com código %d",cozinhaId)
            );
        }
        //atribuir a cozinha ao restaurante
        restaurante.setCozinha(cozinha);


        return restauranteRepository.salvar(restaurante);
    }


    public void remover(Long restauranteId){

        try {
            restauranteRepository.remover(restauranteId);
        }catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de restaurantecom código %d",restauranteId));
        }
        catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format("Restaurante de código %d não pode ser removida, pois está em uso", restauranteId));
        }

    }





    }







