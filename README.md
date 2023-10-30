# microservices-reader-notes

### Current Stack:

1) Spring modules: Data, Security(oAuth 2 with Keycloak), MVC, WebFlux
2) Spring cloud modules: Eureka(discovery server), Gateway, OpenFeign
3) For book-service service use PostgreSQL
4) Kafka for communication between Book service and Notification service
5) Front-end just for test api 
#### Planned to add

1) Circuit Breaker for modules
2) Create logging and monitoring system (SLF4J and  Spring Sleuth with Zipkin)
3) Add tests, ***maybe create scipts to quick testing with docker
4) *** Maybe add Prometheus and graphana
5) *** Maybe Kubernets
### Application explanation

At the moment, 3 functional services are ready :

1) Book service - a service for working with your notes about books. It uses your nickname to save and work with notes.
   Connected to the book search service from OpenFeign. Connected (like producer) to the Notification service(consumer)
   using Kafka.
2) Book search service - a service for using an external API with a connection to Goodreads.com. I am
   using [this API](https://rapidapi.com/roftcomp-laGmBwlWLm/api/hapi-books).
3) Notification service - "mock" of a real email sender service.

And an additional external application "front-application' in Vue 3 with Axios and Keycloak-js (don't look at the code, it's terrible).

I created a docker-compose file with the Book-service database, keycloak with db, Kafka with zookeeper and NGINX with the front-end application
### How to test this application

1) Run the docker-compose file in the root directory - `docker-compose up`
2) Run the microservices with the command `mvn Spring-boot:run` in their root directories in the following order:
     - Discovery-service
     - Api-gateway
     - Book-service
     - Book-search-service and Notification-service
