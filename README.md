# microservices - DRAFT
## service-registration
### generate service skeleton
goto: http://start.spring.io/ and in field Search for dependencies type:

Cloud Boostrap, Web, Eureka Server

### add configuration
```
eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false

server:
  port: 1111
```

### edit main class
add annotation to make this service discovery server
```
@EnableEurekaServer
```

## account-service
### generate service skeleton
goto http://start.spring.io/ and add dependencies (see Search for dependencies field):

Client Config, Cloud Bootstrap, Eureka Discovery

### add configuration
```
spring:
  application:
    name: account-service

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:1111/eureka/

server:
  port: 2222
```

### edit main class
add annotation to make this service discoverable be Eureka
```
@EnableDiscoveryClient
```

## Circuit braker
Warm up: https://spring.io/guides/gs/circuit-breaker/


## FAQ

### EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE
- https://github.com/spring-cloud/spring-cloud-netflix/issues/1195
- https://github.com/spring-cloud/spring-cloud-netflix/issues/1322

### Could not autowire field:RestTemplate in Spring boot application
- http://stackoverflow.com/questions/36151421/could-not-autowire-fieldresttemplate-in-spring-boot-application

### Microservices - RestTemplate UnknownHostException
- http://stackoverflow.com/questions/37159662/microservices-resttemplate-unknownhostexception

### rest POST
Bean must have default constructor and setters, otherwise it can't find proper constructor - find out why.

### Post JSON to spring REST webservice
- http://www.leveluplunch.com/java/tutorials/014-post-json-to-spring-rest-webservice/

## Links
- Microservices: http://www.martinfowler.com/articles/microservices.html
- Microservices: http://www.martinfowler.com/microservices/
- Microservices with spring: https://spring.io/blog/2015/07/14/microservices-with-spring
- Microservice Registration and Discovery with Spring Cloud and Netflix's Eureka: https://spring.io/blog/2015/01/20/microservice-registration-and-discovery-with-spring-cloud-and-netflix-s-eureka
- Microservices: http://microservices.io/
- Spring Boot Reference Guide: http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
- Spring Cloud Netflix: http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html
- Ribbon: http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html#spring-cloud-ribbon
- Service Registration and Discovery: https://spring.io/guides/gs/service-registration-and-discovery/
- Building REST services with Spring: https://spring.io/guides/tutorials/bookmarks/
- Edit wiki guide: https://help.github.com/categories/writing-on-github/

## Licence

MIT License

Copyright (c) [2016] [Tomasz Kozlowski]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
