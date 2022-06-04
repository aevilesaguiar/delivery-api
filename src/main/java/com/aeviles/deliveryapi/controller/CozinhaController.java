package com.aeviles.deliveryapi.controller;


import com.aeviles.deliveryapi.domain.exception.EntidadeEmUsoException;
import com.aeviles.deliveryapi.domain.exception.EntidadeNaoEncontradaException;
import com.aeviles.deliveryapi.domain.model.Cozinha;
import com.aeviles.deliveryapi.domain.repository.CozinhaRepository;
import com.aeviles.deliveryapi.domain.service.CozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController //essa anotação é um controlador e possui @Response body
@RequestMapping("/cozinhas")//todas as requisições /cozinhas vai cair nessa requisição
public class CozinhaController {


        @Autowired
        private CozinhaRepository cozinhaRepository;

        @Autowired
        private CozinhaService cozinhaService;

        @GetMapping
        public List<Cozinha> findAll() {
                return cozinhaRepository.findAll();
        }



        @GetMapping(value = "/{cozinhaId}")// Biding Path variable "cozinhaId" pode ter qualquer outro nome
        public ResponseEntity<Cozinha> findById(@PathVariable Long cozinhaId) { //PathVariable passamos o nome da nossa variavel que queremos fazer um biding

                Cozinha cozinha = cozinhaRepository.findById(cozinhaId);

                if (cozinha != null) { //se a cozinha não está nulo, ou seja existe

                        return ResponseEntity.ok(cozinha);   //retorne a representação da cozinha
                }

                //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                // OU O ATALHO
                return ResponseEntity.notFound().build();  //caso contrário retorne NOTfOUND sem corpo algum

        }



        //metodo salvar/adicionar
        @PostMapping //Mapeamento do método post http
        @ResponseStatus(HttpStatus.CREATED) // O recurso foi criado
        public Cozinha salvar(@RequestBody Cozinha cozinha) { //essa anotação @RequestBody diz que o parametro vai receber o corpo da requisição.Pega o corpo do JSON e vincula com a cozinha
                return cozinhaService.salvar(cozinha);
        }

        //Utilizaremos ResponseEntity por que precisaremos tratar a resposta http
        @PutMapping("/{cozinhaId}")
        public ResponseEntity<?> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) {//@PathVariable variavel de caminho
                                                                                                             //@RequestBody por que queremos receber um corpo, que é a representação que queremos atualizar esse recurso
                                                                                                                //@RequestBody agente está fazendo biding do corpo, o corpo que agente quer que seja atribuida a essa
                                                                                                                //instancia que o spring vai criar de Cozinha e atribui as ptopriedades lá dentro

                try {
                        //cozinhaatual é a cozinha persistida no banco de dados  eu tenho que pegar cozinha e colocar dentro de cozinhaatual
                        Cozinha cozinhaatual = cozinhaRepository.findById(cozinhaId);
                        if (cozinhaatual != null) {
                                //outra forma de fazer usando BeanUtils
                                BeanUtils.copyProperties(cozinha, cozinhaatual, "id"); //Usamos BeanUtils e passamos o copyProperties, passando a origem e o destino  ou seja copie os valores das propriedades de cozinha e coloque dentro de cozinha atual ou seja ele vai pegar o set de cozinhaatual,pegando como valor o get de cozinha
                                cozinhaatual = cozinhaService.salvar(cozinhaatual);

                                return ResponseEntity.ok(cozinhaatual); //200 OK- Estas requisição foi bem sucedida. O significado do sucesso varia de acordo com o método HTTP:

                        }

                        return ResponseEntity.notFound().build();
                } catch (EntidadeNaoEncontradaException e){
                        return ResponseEntity.badRequest().body(e.getMessage());
                }

                }

                //Utilizaremos ResponseEntity por que precisaremos tratar a resposta http e fazer alguma lógica
                @DeleteMapping(path = "/{cozinhaId}")
                public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {//utilizaremos o @PathVariable para fazer o biding dele /{cozinhaId} nesse parametro cozinhaId do método
                        try {
                                cozinhaService.remover(cozinhaId);

                                return ResponseEntity.noContent().build();
                        }

                        //entidade não foi encontrada?
                        catch (EntidadeNaoEncontradaException e){
                                return ResponseEntity.notFound().build();
                        }

                        //entidade esta em uso?
                        catch (EntidadeEmUsoException e) {//quando o recurso não pode ser excluido
                                return ResponseEntity.status(HttpStatus.CONFLICT).build(); //vou lançar a exceção 409 conflict , seria interessante lançar um corpo descrevendo qual foi o problema
                                                                                        //tratamento de exceptions

                        }


                }


}


