package com.example.rabbittutorials.tut2;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

@RabbitListener(queues = "hello")
public class Tut2Receiver {

    private final int instance;

    public Tut2Receiver(int i) {
        this.instance = i;
    }

    @RabbitHandler
    public void receive(String message) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("instance " + this.instance + " [x] Received '" + message + "'");
        doWork(message);
        stopWatch.stop();
        System.out.println("instance " + this.instance + " [x] Done in " + stopWatch.getTotalTimeSeconds() + "s");
    }

    private void doWork(String message) throws InterruptedException {
        for (char ch : message.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}
