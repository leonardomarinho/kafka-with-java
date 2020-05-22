# Kafka with Java and Spring Boot
Just a simple Kafka Producer and Consumer written in Java 11 with Spring Boot.
This is just for study purposes. I've made this just for fun! =)

Everything you'll need is containerized on Docker. So you can test it without too much of a hassle (containers s2).

## How it works

By default this application will listen on port 8080.

There's a producer sending messages to the kafka broker on topic `myTopic`.
There's a consumer listening to events from topic `myTopic` and consuming it on Group `my-group`.

You can access this features via RESTfull API's.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine.

### Prerequisites

```
* JDK 11 or later
* Maven 2.2.7 or later
* Docker 19.0 or later
```

### Usage

This project uses a Makefile which makes it easier for you to execute the main tasks.

`make compile`\
`make test`\
`make package`\
`make run`\
`make deploy`



You can publish an event to Kafka by using the POST method.
```
curl --location --request POST 'localhost:8080/api/kafka' \
--header 'Content-Type: application/json' \
--data-raw '{
	"title": "Amazing Title",
	"message": "Testing like a boss"
}'
```

You can access the events consumed using the GET method.
```
curl --location --request GET 'localhost:8080/api/kafka'
```


## Swagger
You can access an interactive API documentation for this whole project built with Swagger by accessing:

`http://localhost:8080/swagger-ui.html` 

There you can see all the endpoints available, their usage, responses and even try them for yourself.

## Built With

* [Java 11](https://www.java.com/pt_BR/download/) - The language most people love to hate
* [Maven](https://gradle.org/) - Dependency Management
* [SpringBoot](http://spring.io/projects/spring-boot) - Framework used
* [Spring Initializr](https://start.spring.io/) - Bootstrap for SpringBoot applications
* [Docker](https://www.docker.com/) - Containers made simple
* [Swagger](https://swagger.io/) - Documentation and Design Tools for Teams 
* [Kafka](https://kafka.apache.org/) - A distributed streaming platform
## Authors

* **Leonardo Marinho** - [Github](https://github.com/leonardomarinho) | [Deu Tilt](http://deutilt.com.br) | [Linkedin](http://linkedin.com/in/leonardomarinho)