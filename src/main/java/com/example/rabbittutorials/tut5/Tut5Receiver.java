package com.example.rabbittutorials.tut5;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

public class Tut5Receiver {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receiver1(String message) throws InterruptedException {
        receive(message, 1);
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receiver2(String message) throws InterruptedException {
        receive(message, 2);
    }

    private void receive(String message, int receiver) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("instance " + receiver + " [x] Received '" + message + "'");
        doWork(message);
        stopWatch.start();
        System.out.println("instance " + receiver + " [x] Done in " + stopWatch.getTotalTimeSeconds() + "s");
    }

    private void doWork(String message) throws InterruptedException {
        for (char ch : message.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}
