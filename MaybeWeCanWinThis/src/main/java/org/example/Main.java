package org.example;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

//        ExecutorService executor = Executors.newSingleThreadExecutor();
//
//        for (int i = 1; i <= 5; i++) {
//            int taskNumber = i;
//            executor.submit(() -> {
//                System.out.println("Task " + taskNumber + " is being executed by " + Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000); // Simulate task taking time
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Task " + taskNumber + " finished by " + Thread.currentThread().getName());
//            });
//        }
//
//        executor.shutdown();


        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Task scheduled to run every 2 seconds with an initial delay of 1 second
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Scheduled task executed by " + Thread.currentThread().getName());
        }, 1, 2, TimeUnit.SECONDS);

        // Stop the scheduler after 10 seconds for demonstration
        scheduler.schedule(() -> {
            scheduler.shutdown();
            System.out.println("Scheduler stopped");
        }, 10, TimeUnit.SECONDS);

    }
}