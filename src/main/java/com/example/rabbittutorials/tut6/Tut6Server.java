package com.example.rabbittutorials.tut6;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Tut6Server {

    @RabbitListener(queues = "tut.rpc.requests")
    public int fobonacci(int n) {
        System.out.println(" [x] Received request for " + n);
        int result = fib(n);
        System.out.println(" [.] Returned " + result);
        return result;
    }

    private int fib(int n) {
        return n == 0 ? 0 : n == 1 ? 1 : (fib(n - 1) + fib(n - 2));
    }
}
