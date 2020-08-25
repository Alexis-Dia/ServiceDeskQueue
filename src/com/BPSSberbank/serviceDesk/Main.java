package com.BPSSberbank.serviceDesk;

import com.BPSSberbank.serviceDesk.queues.Queue;
import com.BPSSberbank.serviceDesk.queues.SimpleQueueImpl;
import com.BPSSberbank.serviceDesk.threads.Consumer;
import com.BPSSberbank.serviceDesk.threads.Producer;

/**
 * @author Alexey Druzik on 25.08.2020
 * В тестовом задании созданы два потока Producer(добавляет объекты в очередь) и один Consumer(читает из очереди) с
 * разными выдержками.
 */
public class Main {

    private static final int TIME_SLEEP_FOR_FIRST_PRODUCER = 5000;
    private static final int TIME_SLEEP_FOR_SECOND_PRODUCER = 6000;
    private static final int TIME_SLEEP_FOR_FIRST_CONSUMER = 8000;
    private static final String[] WORDS = new String[] {"Саша", "Паша", "Нина", "Леша", "Игорь", "Максим", "Ольга"};
    private static final String[] ADDITION_WORDS = new String[] {"Никон", "Афанасий", "Серафим"};

    public static void main(String[] args) {

        Queue<String> queue = new SimpleQueueImpl();

        new Producer(queue, WORDS, TIME_SLEEP_FOR_FIRST_PRODUCER);
        new Producer(queue, ADDITION_WORDS, TIME_SLEEP_FOR_SECOND_PRODUCER);
        new Consumer(queue, TIME_SLEEP_FOR_FIRST_CONSUMER);

    }

}
