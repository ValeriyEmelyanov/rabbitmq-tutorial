# RabbitMQ Tutorial

based on [RabbitMQ Tutorials](https://www.rabbitmq.com/getstarted.html)

### Technologies

* Java 11
* RabbitMQ
* Spring boot, Spring AMQP, Profiles

## Running

To build the JAR file:

```
./mvnw clean package
```

RabbitMQ must be running.

### Tutorial #1: Hello world

To run the receiver:

```
java -jar target/rabbitmq-tutorials-0.1.jar --spring.profiles.active=hello-world,receiver
```

To run the sender:

```
java -jar target/rabbitmq-tutorials-0.1.jar --spring.profiles.active=hello-world,sender
```

### Tutorial #2: Work queues

To run the receivers:

```
java -jar target/rabbitmq-tutorials-0.1.jar --spring.profiles.active=work-queues,receiver
```

To run the sender:

```
java -jar target/rabbitmq-tutorials-0.1.jar --spring.profiles.active=work-queues,sender
```

### Publish/Subscribe

To run the receivers:

```
java -jar target/rabbitmq-tutorials-0.1.jar --spring.profiles.active=pub-sub,receiver --tutorial.client.duration=60000
```

To run the sender:

```
java -jar target/rabbitmq-tutorials-0.1.jar --spring.profiles.active=pub-sub,sender --tutorial.client.duration=60000
```

### Routing
To run the receivers:

```
java -jar target/rabbitmq-tutorials-0.1.jar --spring.profiles.active=routing,receiver --tutorial.client.duration=60000
```

To run the sender:

```
java -jar target/rabbitmq-tutorials-0.1.jar --spring.profiles.active=routing,sender --tutorial.client.duration=60000
```
