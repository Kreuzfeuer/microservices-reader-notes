# microservices-reader-notes

### Current Stack:

1) Spring modules: Data, Security(oAuth 2 with Keycloak), MVC, WebFlux
2) Spring cloud modules: Eureka(discovery server), Gateway, OpenFeign
3) For book-service service use PostgreSQL
4) Kafka for communication between Book service and Notification service

#### Planned to add

1) Email sender service with Kafka +
2) Circuit Breaker for modules
3) Create logging and monitoring system (Sleuth and Zipkin)
4) Set up configurations, finish Keycloak settings, add tests, maybe create scipts to quick testing
5) *** Maybe add Prometheus and graphana
6) *** Maybe Kubernets

### Application explanation

At the moment, two functional services are ready :

1) Book service - a service for working with your notes about books. It uses your nickname to save and work with notes.
   Connected to the book search service from OpenFeign. Connected (like producer) to the Notification service(consumer)
   using Kafka.
2) Book search service - a service for using an external API with a connection to Goodreads.com. I am
   using [this API](https://rapidapi.com/roftcomp-laGmBwlWLm/api/hapi-books).
3) Notification service - "mock" of a real email sender service.