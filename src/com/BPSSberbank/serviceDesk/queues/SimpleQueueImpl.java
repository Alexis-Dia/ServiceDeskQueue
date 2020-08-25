package com.BPSSberbank.serviceDesk.queues;

import java.util.ArrayList;

/**
 * @author Alexey Druzik on 25.08.2020
 */
public class SimpleQueueImpl<T> implements Queue<T> {

    private ArrayList<T> list = new ArrayList<>();

    @Override
    public void add(T item) {
        list.add(item);
    }

    @Override
    public T remove() {
        return list.remove(0);
    }

    @Override
    public T getByIndex(int index) {
        return list.get(index);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

}
