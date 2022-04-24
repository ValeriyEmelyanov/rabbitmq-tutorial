# RabbitMQ Tutorial

### Technologies
* Java 11
* RabbitMQ
* Spring boot, Spring AMQP, Profiles

### Tutorial #1: Hello world
RabbitMQ must be running.

To build the JAR file:
```
./mvnw clean package
```
To run the receiver:
```
java -jar target/rabbitmq-tutorials-0.1.jar --spring.profiles.active=hello-world,receiver
```
To run the sender:
```
java -jar target/rabbitmq-tutorials-0.1.jar --spring.profiles.active=hello-world,sender
```
