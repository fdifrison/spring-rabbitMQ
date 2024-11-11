package com.fdifrison.consumer.listener;

import java.util.Random;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

@RabbitListener(queues = "work")
public class WorkLoadReceiver {

    private static final int RAISE_EXCEPTION = 2;
    private final int workerNum;

    public WorkLoadReceiver(int workerNum) {
        this.workerNum = workerNum;
    }

    @RabbitHandler
    public void receiveWork(String bigMessage) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("Received by worker" + workerNum + ": '" + bigMessage + "'");
        doWork();
        watch.stop();
        System.out.println("Work Done in " + watch.getTotalTimeSeconds() + "s");
    }

    private void doWork() throws InterruptedException {
        var check = new Random().nextInt(0, 3);
        if (RAISE_EXCEPTION == check) {
            System.out.println("Raising exception... should retry");
            Thread.sleep(1000);
            throw new RuntimeException();
        }
        Thread.sleep(new Random().nextInt(500, 2000));
    }
}
