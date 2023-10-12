# microservices-reader-notes

### Current Stack:
1) Spring modules: Data, Security(oAuth 2 with Keycloak), MVC, WebFlux ( just for webclient) 
2) Spring cloud modules: Eureka(discovery server), Gateway
3) For book-service service use PostgreSQL

#### Planned to add
1) Email sender service with Kafka
2) Circuit Breaker for modules
3) OpeFeign for connection between services
4) Create logging and monitoring system (Sleuth and Zipkin)
5) Set up configurations, finish Keycloak settings, add tests, maybe create scipts to quick testing
6) *** Maybe add Prometheus and graphana
7) *** Maybe Kubernets

### Application explanation
At the moment, two functional services are ready :
1) Book service - a service for working with your notes about books. It uses your nickname to save and work with notes.
2) Book search service - a service for using an external API with a connection to Goodreads.com.  I am using [this API](https://rapidapi.com/roftcomp-laGmBwlWLm/api/hapi-books).
