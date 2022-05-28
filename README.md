# MODELAGEM DE REST API

## Assuntos abordados:

- Introdução[ok]
- Spring e Injeção de dependencias
- 


# Introdução 

## Projeto a ser Desenvolvido

Sistema de Delivery de Comida, tipo Ifood/Uber Eats, Será um MVP(Produto minimo Viavel) de sistema de comidas;


## Tecnologias

- Maven
- Spring Data JPA (biblioteca que vai ajudar a criar repositorio para usa o jakarta persistence)
- POSTMAN (para testar uma restApi, as requisições)
- Mysql Server
- Flyway (ferramenta para gerenciamento de schema de banco de dados, para manutenção das colunas, tabelas relacionamentos e etc)
- Spring Boot DevTools (restarta a aplicação automaticamente)

- 


## API

- O que é uma API? 

Aplicattion Programming Interface(Interface de programação de aplicação). É um componente de 
Software que possui um conjunto de funções que faz a intermediação de acesso a funcionalidades de algum sistema.

**Para que possa existir uma API é necessário existir dois papeis.**

SOFTWARE CONSUMIDOR <-> API <-> SOFTWARE PROVEDOR.

![image](https://user-images.githubusercontent.com/52088444/170829045-0a1611b5-1ddb-4c1c-a586-5aaf65b281fc.png)

O software consumidor conversa com o software provedor através de uma API.

## Web Services x APIS(é muito amplo) ,

Web Services são um tipo de API que fornece a sua interface de comunicação pela web.Quando flamos em WebServices estamos
falando de webApi. Uma API não necessariamente precisa servir ao publico externo apenas, mas também ao publico interno.

Todos webservices são APIS, mas nem toda API é webService.

Existem diversas APIS expostas no mundo, dificilmente uma aplicação moderna não consome uma API. 

## Exemplos de API:

![image](https://user-images.githubusercontent.com/52088444/170829151-b565bc36-c83c-4448-a6ca-70227bf5db93.png)


Exemplo de uma API do Ifood

SOFTWARE RESTAURANTE <-> API DO IFOOD <-> IFOOD

GRAÇAS A API OS RESTAURANTES PODEM AUTOMATIZAR OS SEUS PEDIDOS

Outro Exemplo - Consumindo webServoices de um provedor:

O agendador de POSts seria um software utilitário para consumir uma API nesse caso o Linkedin
![image](https://user-images.githubusercontent.com/52088444/170829280-9685afd7-2a65-4f7f-8123-051cdf65f4be.png)

Consumindo Web Services de vários provedores:

![image](https://user-images.githubusercontent.com/52088444/170829346-1ad53cb7-0df1-415a-b48c-c9fc4d347b2a.png)

Posso ter uma aplicação, onde o cliente chega a uma agencia de viagem, onde o meu software consulta as Apis para verificar quais pacotes são
mais baratos. Uma única aplicação consulta várias APIS e verifica a melhor opção. Lembrando que as Apis utilizada por sua aplicação pode estar consultando
outras APIS.


APIS consumidas por suas User Interfaces e outros sistemas

![image](https://user-images.githubusercontent.com/52088444/170829431-87293849-efc4-458c-931c-92281fd60167.png)

API consultando outras APIS, um exemplo um aplicativo mobile que consulta a sua própria API, a sua API consulta a melhor opção para o cliente,
podemos ter sites, sistemas internos consumindo a sua API. E podmos também expor a minha API para empresas externas, através de comissão e oytros.


## Exemplos reais de WEB APIS ( Podemos fazer várias integrações com essas APIS)

- Spotify: [https://developer.spotify.com/documentation/web-api/reference/#/operations/get-new-releases]
- Ifood : https://developer.ifood.com.br/pt-BR/
- portal transparecnia do governo: https://portaldatransparencia.gov.br/api-de-dados/cadastrar-email
- Mercado livre: https://developers.mercadolivre.com.br/pt_br/desenvolvimento-seguro (desenvolver um software para ajudar os vendedores/ ou fazer uma integração com ERP para facilitar para os usuarios dessas empresas)
- enotas : https://docs.enotasgw.com.br/docs  (enotas facilita pois expôe sua API e através do enotas pois podemos emitir notas fiscais para diversas prefeituras - paga)
- outras milhares de APIS pagas ou gratuitas 

## O que é REST

REST:acrônimo REpresentational State Transfer, é um estilo arquitetural para desenvolver WEB API'S, ou seja para desenvolver WEB SERVICES,
REST é uma especificação que define a forma de comunicação entre componentes de software na web, independente da linguagem de programação usada.

REST surgiu nos anos 2000, a partir da tese de PHD de um cientista chamado Roy Fielding, seu intuito era formalizar um conjunto de melhores práticas
para desenvolvimento de webServices, essas melhores práticas são chamadas de constraints(regras) que devem ser seguidas para uma API ficar em conformidade com
REST, então uma RESTAPI é uma API que segue as regras especificadas por Roy Thomas Fielding.

Rest é um estilo arquitetural utiliado para desenvolver REST APIS/ WEB Services, ele foi desenvolvido para usar protocolos que já existem, como o HTTP.

Para que uma aplicação possa consumir uma REST API ela precisa conheceer apenas o protocolo HTTP não precisa instalar nada. E essa facilidade de integração 
entre os sistemas, fez com que REST se torna-se a forma mais popular para desenvolver webServices. As APIS mostradas acima utilizam a arquitetura REST.


## Por que usar REST?

- Separação entre cliente(quem consome a api) e servidor(quem provê a API), dessa forma nós temos uma maior flexibilidade e portabilidade.
- Escalabilidade, se um servidor não está sendo sufiente , podemos incluir outros;
- Independência de linguagem;
- As APIS podem interagir entre si;


## Constraints

- Cliente-servidor( nós precisamos de um cliente que pode ser uma aplicação front-end, mobille, uma outra API enviando requisições para um servidor, as aplicações
  cliente servidor podem evoluir sem inteferir no outro, inclusive um cliente x servidor pode ser substituído sem interferir em nada, desde que a interface
  entre eles seja inalterada.

- Stateless significa sem estado, a aplicação não deve ter estado, Roy Fielding se inspirou no protocolo http para essa constraint, na prática quer dizer que
  essa requisição feita ao servidor da API , deve conter tudo para que seja devidamente processada. O servidor não pode manter uma seção.
- Cache, a API pode fazer cache das requisições, cache é uma memória de consulta rápida, ela melhora a escalabilidade do servidor, pois reduzimos o numeros de hits
  no servidor, ou seja numero de acesso. (possibilidade de incluir quando necessário)
- Interface Uniforme (desacopla a arquitetura) para ficar de acordo com essa constraint devemos identificar os recursos do sistema usando URI's seguindo umpadrão;
- devemos usar o padrão do protocolo de comunicação para interagir com a API, geralmente usamos o verbo do protocolo http( put, get, delete, post...)
- A resposta de uma requisição deve ser padronizada;
- Sistema em camadas, a possibilidade entre o cliente que consome e o servidor que hospeda a API ter outros servidores no meio do caminho,
  esses servidores podem oferecer uma camada de segurança, de cache, balanceamento de carga, o cliente não deve conhecer quantas camadas possuem no meio
- Código sobe demanda(opcional) o servidor pode enviar como resposta de um código;



## PROTOCOLO HTTP

O modelo arquitetural REST independe de linguagem e tecnologia, REST não restringe o uso de um protocolo em particular, apesar do modelo ser independente
de protocolo, para colocar REST m prática é necessário o uso de um, e o mais usado é o protocolo http.

COMO FUNCIONA O PROTOCOLO HTTP

CLIENTE <=> REQUISIÇÃO X RESPOSTA<=> SERVIDOR

COMPOSIÇÃO DA REQUISIÇÃO

[MÉTODO] [URI] HTTP/[VERSÃO]
[Ccabeçalhos]

[CORPO/PAYLOAD]


-----------------------------
POSTprodutos HTTP/.
content-Type: application/json
Accept: application/json
{
"nome": "Notebook",
"preco": 2100.00
}

Método -> indica a ação que queremos que seja executado; (GET, POST, PUT, DELETE)


URI-> caminho que identifica o que queremos dentro do servidor http. POST /produtos em palavras cadastrando produtos

Corpo/Payload, não é obrigatório, e é nesse corpo que enviamos oa dados para API

composição da resposta


HTTP /[VERSAO][STATUS]
[Cabeçalhos]

[CORPO]


-----------------------------
HTTP/1.1 201 Created
Location: /produtos/331
content-Type: application/json
{
"cosdigo":331,
"nome": "Notebook",
"preco": 2100.00
}

status serve para descrever o resultado da requisição (201 created- um recurso foi criado com sucesso)
corpo da resposta: é onde fica o conteudo da resposta


## RECURSOS REST

Um recurso é qualquer coisa exposta na web, é algo que tem importancia para ser refenciado no software. Exemplo: documento, pagina, video, foto,
até mesmo um processo de negócio, em um ecommerce um produto pode ser considerado um recurso.

Singleton Resource.Um recurso é uma instancia de uma determinada classe. Um recurso que significa uma unica coisa é chamado de singleton Resource.
Os recusos podem ser agrupados em coleções(collection Resource)Coleção de Produtos é um recurso.

## IDENTIFICANDO RECURSOS

REST utiliza URI para identificar os Recursos, URI é uniforme Resource Identifier, identificador de recurso uniforme, nada mais é que um conjunto
de caracteres  que tem como objetivo dar um endereço para os recursos de forma não ambigua.

Quando modelamos um recurso temos que pensar em um tipo de URI para identifica-los.

URI X URL: URL é um tipo de URI.

Ex: /listasProdutos

url Completa: httpd://api.algamarket.com.br/listasProdutos

Não é uma boa pratica identificar uma URI dessa forma

o corretos é : /produtos
sem identificar ação

RECURSO UNICO
/produto/{codigo}

url Completa: httpd://api.algamarket.com.br/produtos/331

temos que usar o recurso sempre no plural, pois facilita o consumidor da API e quem desenvovle


# Spring e Injeção de Dependências


## O que é Spring REST?

Spring Rest não existe, é apenas um termo para se dizer que temos uma REST API desenvolvida com Spring.

## O que é Spring?

Um ecossistema de projeto, ajuda a desenvolver aplicações com simplicidade e flexibilidade.
O foco do Spring é foco na regra do negócio.Reduzir complexidade do Negócio. Possui maturidade e modularidade.
O Spring está em evolução constante. Spring é openSource e tem uma comunidade forte além de ser muito popular.

Quando falamos em Spring Framework, estamos falando de um projeto que serve como base para todos os outros.

Features
-Spring MVC: usado para Web
-Core tecnologies: base do spring pois está a injeção de dependencia para o Objeto funcionar;
- e muitos outros

Spring Data é um projeto guarda-chuva que agrupa vários outros projetos relacionados a acesso a dados.

- Utilizaremos o Spring Data JPA: ele ajuda a implementar repositórios JPA de forma simples(conhecido como jakarta Persistence),
  Jpa é uma especificação de persistencia de dados para java, ou seja uma tecnologia usada para trabalhar com acesso e com as operações
  relacionadas ao banco de dados relacional usando Java.


Codigo boilerPlate: codigo que precisa escrever várias vezes sendo repetitivos;

Spring Boot: é um projeto que ajuda a criar projetos que se alto configuram, seguindo convenções, não é necessário se preocupar com
a maioria das configurações, eles podem configurar não só os projetos do seu ecossitema, mas também de bibliotecas terceiras.
Spring Boot não gera código, não substitui Spring MVC,Data e outros , ele apenas complementa os outros projetos;

O spring boot incorpora um servlet container, por padrão é o tomcat dentro do jar da aplicação. Dentro do jar ele já tem um container com o tomcat embutido,
ou seja ele já sobe a aplicação

O spring boot apenas ajuda a criar o projeto, não gera código, quando criamos um projeto inicial no springInitializer ela cria uma classe main.

Pensando um pouco no maven que um gerenciador de dependencias, para reduzir a quantidade de linhas de código, utilizamos os startes, que são dependencias 
que agrupam outras dependencias. um exemplo se quisermos trabalhar com jpa podemos incluir o start nas dependencias do POM. 

![image](https://user-images.githubusercontent.com/52088444/170832633-e3b2fc5c-0124-4f54-9fea-18b16ca4f825.png)


## Spring boot ou Spring MVC

Spring boot não é um framework só para desenvolvimento WEB, mas você pode usar Spring boot para aplicações que rodam fora da web. 
Spring boot é uma camada de abstração em cima do spring, é uma camada que simplifica ainda mais o desenvolvimento das nossas aplicações, inclusive
spring MVC.

## Spring MVC

Spring MVC é um projeto do ecossistema Spring para desenvolver controladores web que recebem requisições HTTP, e develvem uma 
resposta, podem ser ResrApi ou devolver html ou qualquer outro tipo de arquivo.

O Spring MVC foi adicionado no projeto através do start "web" que incluimos na geração do projeto nas dependencias do maven.

## Spring vs Jakarta EE(Java EE)

Jakarta EE administrado pelo o Eclipse Foundation. A plataforma java EE foi batizada de Jakarta EE. Java EE é baseada em especificações. Um exemplo o JPA é uma especificação que está dentro do jakarta EE,
o JEE é uma especificção guarda chuva que tem várias sub especificações, JPA está dentro do JEE, JPA foi a padronização de algo que já existia, o Hibernate. 
Hibernate após a padronização passou a implemetar a especificação, então o hibernate passou a se tornar o produto a implementação da especificação JPA.

Muitos confundem a diferença entre o Hibernate e o JPA. O Hibernate é de fato o framework ORM, ou seja, a implementação física do que você usará para persistir, remover, atualizar ou buscar dados no SGBD. Por outro lado, o JPA é uma camada que descreve uma interface comum para frameworks ORM.

Hoje o hibernate tem outros concorrentes, se hoje falarmos que estamos usando o JPA não necessariamente estamos o hibernate. 

O Hibernate é um framework para o mapeamento objeto-relacional escrito na linguagem Java, mas também é disponível em .Net com o nome NHibernate.

Com JPA, se houver a necessidade de alterar o sistema de banco de dados, basta trocar o dialeto que um novo e compatível SQL é gerado em tempo de execução. Interessante notar também que o uso do JPA permite que a implementação da especificação seja alterada sem impactos no fonte da aplicação.


## O que é o Java EE?

O Java EE (Java Enterprise Edition) consiste de uma série de especificações bem detalhadas, dando uma receita de como deve ser implementado um software que faz 
cada um desses serviços de infraestrutura.




## O que é Maven

Maven é uma ferramenta de gerenciamento de dependencias e automação de build de projetos java.
Não necessariamente precisa ser com spring.

A estrutura de pastas é padronizada pelo o Maven.

Na raiz do projeto temos os arquivo pom.xml. É onde ficam as configurações de maven no projeto.

pom-> object project model

o arquivo HELP.md é apenas um arquivo que podemos incluir alguma observação do projeto, mas não influencia em nada.

mvnw.cmd e mvnw -> maven wrapper, ele possilita que executemos um maven no terminal, mesmo que não tenha um maven instalado você
não precisa instalar no Sistema operacional. Ou seja ele baixa automaticamente da internet.

Várias IDES já possuem um maven embutido dentro dele.

O maven ajuda a fazer o build do projeto, mas como fazer esse build?
Eu posso clicar em cima do projeto -> Run as -> Maven build, que eu rodo o build do maven. Vai aparecer as configurações.

O package significa que eu quero empacotar, no console roda o maven  e ele gera o pacote, gera o jar dentro da pasta target
dentro do projeto, dentro dele existem várias pastas , o mais importante é o jar.

No terminal eu posso fazer dessa forma também usando o comando:

**escrevi o comando mvn clean package, posso ** ele limpa e gera o jar do nosso projeto. Ou seja ele gera o Build.

Esse arquivo jar é o nosso projeto empacotado, eu posso encaminhar ele por email para que alguém pudesse utilizar o projeto.

**mvn clean - limpa os arquivos anteriores do build

## Class Loader

Class loader ela é responsável por ler a estrutura das classes do nosso projeto e ficar na memória
Ele cria duas class loader, um chamado de base e outro de restart. Tudo que não muda, por exemplo as bibliotecas
ele adiciona no class loader de base, e o que desenvolvemos ele inclui no class loader restart.
Toda vez que alteramos o que desenvolvemos ele reinicia o class loader de restart, e isso torna muito mais rápido o 
desenvolvimento.

## O que é injeção de Dependencias

Injeção de dependência é um padrão de desenvolvimento de programas de computadores utilizado quando é necessário 
manter baixo o nível de acoplamento entre diferentes módulos de um sistema.

Injeção de Dependência é um é um padrão de projeto usado para evitar o alto nível de acoplamento de código.

## Spring IOC Container 

É a implementação de  injeção de dependências do Framework. É algo bem comum em Frameworks que implementam inversão de 
controler/inversão no spring nós temos o Spring Context, ele é reponsável pela injeção de dependencias, como instanciar, de configurar 
injetar Objetos em outros objetos.

No Spring quando rodamos uma aplicação o IOC Container, ele é inicializado e começa a instancializar os Beans que ele deve gerenciar.
Bean(Dependence/dependencia) é nome dado a objetos gerenciados pelo o container do Spring. O Bean é instanciado, ele é configurado e 
pode ser injetado em outros Beans que são gerenciados pelo o Container do spring.

![image](https://user-images.githubusercontent.com/52088444/170840887-f49f75ea-8562-440b-8ea1-7c017f33e3d1.png)

O Container de inversão de Controler do Spring é representado pela interface Aplication Context.

## Anotações

- @Controller : quando eu anoto uma classe com essa inscrição, eu estou dizendo que ela é reponsável por receber requisições web.




## maneira de atualizar a aplicação quando ocorre alteração

Incluir no maven o starter : 


## Metodos http /Verbos http

Métodos http também conhecido como verbos http. Através dos métodos http nós dizemos para o servidor qual
tipo de serviço nós devemos executar em um determinado recurso indentificado pela URI.

Método GET : é usado quando existe a necessidade de obter a representação  de um recurso. O GET não gera efeito
colateral, não tem alteração no estado sa aplicação. O GET não é usado para mudar um recurso, por isso ele 
é chamado idempotente.

Idempotente: significa que requisições repetidas na sequencia não geram efeito colateral;


## Códigos de Status

 Mais conhecidos:

- 200 - ok (Esse tipo de código indica que a solicitação foi bem-sucedida. A carga útil enviada em uma reação 200 depende da técnica de solicitação. Para os sistemas)
- 201 - created(A solicitação foi atendida e trouxe pelo menos um novo recurso sendo feito. O recurso essencial feito pelo pedido é reconhecido)
- 204 - no content (O servidor satisfez efetivamente a solicitação e que não há conteúdo extra para enviar no corpo da carga de reação. Metadados na reação)
- 400 - Bad Reques
- 401 - Unauthorized
- 404 - Not Found
- 500 - Internal Server Error(um erro que o servidor não consegue tratar)


## Representações para recursos

Hoje utilizamos com mais frequencia o json, mais pode ser alterado pelo o consumidor da APIatravés do cabeçalho accept na
requisição.

Headers (cabeçalhos http): é nesse campo que espedivifamos os cabeçalhos customizados;

- Accept (cabeçalho padrão, que nós consumidores da Api aceitamos como respostas): application/json(application media type)


- Negociação de Conteúdo(Content Negotiation) posso escolher o formato que preciso

Json Padrão

![image](https://user-images.githubusercontent.com/52088444/169176869-519c2433-81c1-4a77-923f-4081ed4493df.png)

Alterando para XML

![image](https://user-images.githubusercontent.com/52088444/169176762-60fb6bd5-0132-4747-b5a5-e065c5213a72.png)

Para alterar o tipo de arquivo para outro formato além do json, é necessário configurar o servidor;


Para trabalhar com o formato xml inclui no gerenciador de dependencias o jackson

<!-- jackson é uma biblioteca utilizada para serializar e desiarilizar os objetos, ou seja fazer a transformar um tipo 
de objeto java para xml ou outros. -->
		<dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-xml</artifactId>

		</dependency>
		
		
		
		
		
		
		
		
		
## Diferença entre JPA E JDBC

JPA é mais rapido no desenvolvimento, e menos trabalhoso. Já que no JDBC você usa SQL nativo para trabalhar diretamente com os registros, enquanto que no JPA você trabalha com objetos criados a partir desses registros, concluímos que a performance da primeira tecnologia é maior que a da segunda.
		
Diferença Hibernate e JPA





## Flyway

O Flyway é um framework que permite o versionamento e gerenciamento do Banco de dados, com ele podemos controlar a 
evolução dos elementos que compõem uma determinada base de dados, sendo eles Tabelas, Sequences, Views, entre outros.


Podemos utilizar o Flyway para manipular diferentes sistemas de Banco de dados relacionais, isso é possível porque ele é
desenvolvido baseado na API JDBC onde basta especificar o Driver do banco e realizar as migrações.

O Flyway pode ser utilizado através de linha de comando, ou utilizando ferramentas como Maven, Gradle, Ant, SBT, 
entre outras.

Criando os Scripts

Os scripts são criados utilizando a linguagem SQL ou através de uma API Java, neste exemplo utilizaremos SQL, o Flyway 
segue uma convenção para o nome dos Scripts, que é V{numero da versão}__<nome_do_script>.sql, estes scripts devem ser 
adicionados dentro do diretório sql(são dois underscore após o numero da versão).

## Referencias

- (Códigos http)[https://www.iana.org/assignments/http-status-codes/http-status-codes.xhtml#http-status-codes-1]

- https://httpstatus.com/
-  https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-reference-jdbc-url-format.html











