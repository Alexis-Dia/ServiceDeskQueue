package com.BPSSberbank.serviceDesk.threads;

import com.BPSSberbank.serviceDesk.queues.Queue;

/**
 * @author Alexey Druzik on 25.08.2020
 */
public class Consumer implements Runnable {

    private Queue<String> queue;
    private Thread thread;
    private Integer timeSleep;

    public Consumer(Queue<String> queue, Integer timeSleep) {
        this.queue = queue;
        this.timeSleep = timeSleep;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(timeSleep);
                if (!queue.isEmpty()) {
                    String element = queue.remove();
                    System.out.println("consumer: обработал из очереди " + element + ", число элементов в очереди: " + queue.size());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
