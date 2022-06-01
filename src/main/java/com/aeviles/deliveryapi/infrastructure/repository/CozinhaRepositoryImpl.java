package com.aeviles.deliveryapi.infrastructure.repository;

import com.aeviles.deliveryapi.domain.model.Cozinha;
import com.aeviles.deliveryapi.domain.repository.CozinhaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> findAll() {
        TypedQuery<Cozinha> query = manager.createQuery("from cozinha", Cozinha.class);

        return query.getResultList();

        /*
         * poderia ser mais limpo o código
         * return manager.creatQuery("from cozinha",Cozinha.class)
         *            .getResultList();
         * */

    }

    @Override
    @Transactional//quando eu anoto um método com transactional esse método vai ser executado dentro de uma transação
    public Cozinha salvar(Cozinha cozinha) {
        //insert into cozinha (nome) values
        //merge fundir, incluir a entidade cozinha dentro do contexto de persistencia
        //o metodo merge não altera a instancia que está passando como parametro
        //quando incluimos uma nova cozinha , um id é atribuido pelo o BD  de dados pois ele é autoincremento
        //esse id não é atribuido na instancia Cinha e sim no método merge.
        return manager.merge(cozinha); //
    }

    @Override
    public Cozinha findById(Long id) {

        return manager.find(Cozinha.class, id);
    }

    @Override
    @Transactional //para ele ser executado dentro de uma transação
    public void remover(Cozinha cozinha) {
        cozinha = findById(cozinha.getId()); //isso é um find
        manager.remove(cozinha);

    }

}


