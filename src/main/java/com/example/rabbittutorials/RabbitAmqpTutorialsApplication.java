package com.example.rabbittutorials;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitAmqpTutorialsApplication {

    @Profile("usage_message")
    @Bean
    public CommandLineRunner usage() {
        return args -> {
            System.out.println("This app uses Spring Profiles to control its behavior.\n");
            System.out.println("Options are: ");
            System.out.println("# Hello world");
            System.out.println("java -jar rabbit-tutorials-0.1.jar --spring.profiles.active=hello-world,receiver");
            System.out.println("java -jar rabbit-tutorials-0.1.jar --spring.profiles.active=hello-world,sender");
            System.out.println("# Work queues");
            System.out.println("java -jar rabbit-tutorials-0.1.jar --spring.profiles.active=work-queues,receiver");
            System.out.println("java -jar rabbit-tutorials-0.1.jar --spring.profiles.active=work-queues,sender");
            System.out.println("# Publish/Subscribe");
            System.out.println("java -jar rabbit-tutorials-0.1.jar --spring.profiles.active=pub-sub,receiver");
            System.out.println("java -jar rabbit-tutorials-0.1.jar --spring.profiles.active=pub-sub,sender");
            System.out.println("# Routing");
            System.out.println("java -jar rabbitmq-tutorials-0.1.jar --spring.profiles.active=routing,receiver");
            System.out.println("java -jar rabbitmq-tutorials-0.1.jar --spring.profiles.active=routing,sender");
            System.out.println("# Topics");
            System.out.println("java -jar rabbitmq-tutorials-0.1.jar --spring.profiles.active=topics,receiver");
            System.out.println("java -jar rabbitmq-tutorials-0.1.jar --spring.profiles.active=topics,sender");
            System.out.println("# RPC");
            System.out.println("java -jar rabbitmq-tutorials-0.1.jar --spring.profiles.active=rpc,server");
            System.out.println("java -jar rabbitmq-tutorials-0.1.jar --spring.profiles.active=rpc,client");
        };
    }

    @Profile("!usage_message")
    @Bean
    public CommandLineRunner tutorial() {
        return new RabbitAmqpTutorialsRunner();
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitAmqpTutorialsApplication.class, args);
    }

}
