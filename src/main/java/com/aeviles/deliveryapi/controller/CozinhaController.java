package com.aeviles.deliveryapi.controller;


import com.aeviles.deliveryapi.domain.model.Cozinha;
import com.aeviles.deliveryapi.domain.model.CozinhaXmlWrapper;
import com.aeviles.deliveryapi.domain.repository.CozinhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//GET /cozinhas HTTP/1.1
//Response: cozinhaRepository.findAll();

import java.util.List;
import java.util.Optional;

@RestController //essa anotação é um controlador e possui @Response body
@RequestMapping("/cozinhas")//todas as requisições /cozinhas vai cair nessa requisição
public class CozinhaController {


        @Autowired
        private CozinhaRepository cozinhaRepository;

        @GetMapping
        public List<Cozinha> findAll() {
                return cozinhaRepository.findAll();
        }


        @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
        //RESPONDER APENAS QUANDO O CONSUMIDOR PEDIR O FORMATO XML
        public CozinhaXmlWrapper listarXml() {

                //lista umn embrulho do do ObjetoWrapper
                return new CozinhaXmlWrapper(cozinhaRepository.findAll());
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


        @PostMapping //Mapeamento do método post http
        @ResponseStatus(HttpStatus.CREATED) // O recurso foi criado
        public Cozinha adicionar(@RequestBody Cozinha cozinha) { //essa anotação @RequestBody diz que o parametro vai receber o corpo da requisição.Pega o corpo do JSON e vincula com a cozinha
                return cozinhaRepository.salvar(cozinha);
        }

        //Utilizaremos ResponseEntity por que precisaremos tratar a resposta http
        @PutMapping("/{cozinhaId}")
        public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) {//@PathVariable variavel de caminho
                                                                                                             //@RequestBody por que queremos receber um corpo, que é a representação que queremos atualizar esse recurso
                                                                                                                //@RequestBody agente está fazendo biding do corpo, o corpo que agente quer que seja atribuida a essa
                                                                                                                //instancia que o spring vai criar de Cozinha e atribui as ptopriedades lá dentro

                //cozinhaatual é a cozinha persistida no banco de dados  eu tenho que pegar cozinha e colocar dentro de cozinhaatual
                Cozinha cozinhaatual = cozinhaRepository.findById(cozinhaId);

                /*
                //temos apenas um atributo, se tivemos mais , teriamos que fazer um a um.
                cozinhaatual.setNome(cozinha.getNome());*/

                if(cozinhaatual!=null){
                        //outra forma de fazer usando BeanUtils
                        BeanUtils.copyProperties(cozinha, cozinhaatual, "id"); //Usamos BeanUtils r passamos o copyProperties, passando a origem e o destino
                        //ou seja copie os valores das propriedades de cozinha e coloque dentro de cozinha atual
                        //ou seja ele vai pegar o set de cozinhaatual,pegando como valor o get de cozinha
                        cozinhaRepository.salvar(cozinhaatual);

                        return ResponseEntity.ok(cozinhaatual); //200 OK- Estas requisição foi bem sucedida. O significado do sucesso varia de acordo com o método HTTP:


                }
                return  ResponseEntity.notFound().build();


                }

                //Utilizaremos ResponseEntity por que precisaremos tratar a resposta http e fazer alguma lógica
                @DeleteMapping(path = "/{cozinhaId}")
                public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {//utilizaremos o @PathVariable para fazer o biding dele /{cozinhaId} nesse parametro cozinhaId do método
                        try {
                                Cozinha cozinha = cozinhaRepository.findById(cozinhaId);

                                if (cozinha != null) {
                                        cozinhaRepository.remover(cozinha);

                                        return ResponseEntity.noContent().build();
                                }

                                return ResponseEntity.notFound().build();
                        } catch (DataIntegrityViolationException e) {//quando o recurso não pode ser excluido
                                return ResponseEntity.status(HttpStatus.CONFLICT).build(); //vou lançar a exceção 409 conflict , seria interessante lançar um corpo descrevendo qual foi o problema
                                                                                        //tratamento de exceptions

                        }


                }


}


