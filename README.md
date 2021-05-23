# DIO-cities-api
## Proposito<br>
#### Projeto feito no Digital Innovation One, construção de um crud, usando Docker para gerar um container do Postgresql, Hibernate, Spring boot

## Descrição <br>
#### Como o título já demonstra, o meu projeto irá gerar a distância em km das cidades e também mostrará quantas horas irá levar para chegar na cidade percorrendo aqueles km.

## Tecnologia envolvidas

*	Java 1.8
*	 Spring boot
*	 Gradle
*	 Hibernate
*	 Postgresql
*	 Docker
*	Heroku
*	IntelliJ
*	Postman
*	Github e Git


## Projeto em produção
#### https://stark-harbor-69086.herokuapp.com/countries

## Explicando condições de Entrada
* https://stark-harbor-69086.herokuapp.com/countries - acessar a lista de países
* https://stark-harbor-69086.herokuapp.com/staties - lista de estados
* https://stark-harbor-69086.herokuapp.com/cities - lista de cidades do Brasil
* https://stark-harbor-69086.herokuapp.com/distances/travel-seconds?from=10&to=300&kmH=80 -acessar condição específcia

## Explicando condição específica:
#### /distances/travel-seconds?from=10&to=300&kmH=80
* Primeiro há o distances como um Requestmapping definindo o path. 
* Depois há getMapping, a requisição de path travel-seconds vai ser um parâmetro que mudará conforme o que o usuário quiser receber como resultado. 
* travel-hours para receber quantas horas a viagem vai durar;
* travel-seconds para receber quantos segundos a viagem vai durar; 
* travel-minutes para receber quantos minutos a viagem vai durar;
* Os outros parâmetros from indica cidade de origem, passando o valor do id from=10;
* To indica a cidade destino, passando o valor do id to=30;
* kmH vai ser o parâmetro que indica o valor médio em que o veículo fará o percurso, no caso correrá há 80km por hora.


