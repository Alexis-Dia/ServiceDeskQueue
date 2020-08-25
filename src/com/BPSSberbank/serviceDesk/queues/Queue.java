package com.BPSSberbank.serviceDesk.queues;

/**
 * @author Alexey Druzik on 25.08.2020
 */
public interface Queue<T> {
    void add(T item);   // добавить элемент в конец очереди

    T remove();         // извлечение элемента из начала очереди

    T getByIndex(int index);

    boolean isEmpty();

    int size();

}

