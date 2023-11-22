# microservices-reader-notes

### Current Stack:

1) Spring modules: Data, Security(oAuth 2 with Keycloak), MVC, WebFlux
2) Spring cloud modules: Eureka(discovery server), Gateway, OpenFeign
3) For book-service service use PostgreSQL
4) Kafka for communication between Book service and Notification service
5) Front-end just for test api 
#### Planned to add

1) Configuration Prometheus and Graphana
2) Book-service with MongoDB
3) Maybe check K8s
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

1) Run the `mvn clean package -DskipTest` in the root directory
2)  Append this to the end of the host file: `127.0.0.1    keycloak`

   Windows: `C:\Windows\System32\drivers\etc\hosts`

   Linux: `/etc/hosts`

  
3) Run the docker-compose file in the root directory - `docker compose up`
4) Go to `localhost:8085` , create an account, log in and work with notes
