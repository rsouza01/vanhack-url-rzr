# Assignment: URL Shortener [![Build Status](https://travis-ci.org/rsouza01/vanhack-url-rzr.svg?branch=master)](https://travis-ci.org/rsouza01/vanhack-url-rzr)

## Description

Most of us are familiar with seeing URLs like bit.ly or t.co on our Twitter or Facebook feeds. These are examples of shortened URLs, which are a short alias or pointer to a longer page link. For example, I can send you the shortened URL http://bit.ly/SaaYw5 that will forward you to a very long Google URL with search results on how to iron a shirt.

## Mandatory Requirements

- Design and implement an API for short URL creation
- Implement forwarding of short URLs to the original ones
- There should be some form of persistent storage
- The application should be distributed as one or more Docker images

## Additional Requirements

- Design and implement an API for gathering different statistics

## Assessment

Treat this as a real project. It should be readable, maintainable, and extensible where appropriate.

The implementation should preferably be in Java, however any language can be used.

If you will transfer it to another team - it should be clear how to work with it and what is going on.

You should send us a link to a Git repository that we will be able to clone.

### Links (References)

- https://www.concretepage.com/spring-boot/spring-boot-crudrepository-example#Interface
- https://www.baeldung.com/spring-jpa-test-in-memory-database
- https://www.baeldung.com/building-a-restful-web-service-with-spring-and-java-based-configuration#controller

- http://localhost:8080/h2-console

### Running the project

First, you have to build the project and finally the docker image. Both procedures are inside the file publish-server-mvn.sh. Once the server is running, you can run the tests either by using Postman or runing the `run-tests.sh` script (curl is a dependency). 

### API Documentation

- Swagger documentation can be accessed via  http://localhost:8080/v2/api-docs

- Swagger UI can be accessed by http://localhost:8080/swagger-ui.html


#### Shorten URL
- Endpoint: /
- Method: POST
- Data: '{"url":[string]} - Example: {"url":"http://www.rodrigosouza.net.br"}
- Success response code: 200
- Content: url shortened [string]
- Error response: 400 (bad request for invalid URLs) or 500 (internal server error)
- Sample call:  curl -i --data '{"url":"http://www.rodrigosouza.net.br"}' -H "Content-Type: application/json" -X POST http://localhost:8080/


#### Redirect to URL
- Endpoint: /{shortenedUrl}
- Method: GET
- URL Params(required): shortenedUrl:[string] (example:shortenedUrl=b9a982c) 
- Success response code: 301 (MOVED_PERMANENTLY, redirection)
- Error response: 404 (url not found)
- Sample call:  curl -i -H "Content-Type: application/json" -X GET http://localhost:8080/b9a982c


#### Redirect to URL
- Endpoint: /{statistics}
- Method: GET
- Success response code: 200 (SUCCESS)
- Sample call:  curl -i -H "Content-Type: application/json" -X GET http://localhost:8080/statistics


