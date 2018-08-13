package io.github.miareko.samples.datastruct.queuestack;

import java.util.LinkedList;

/**
 * created by miareko on 2018/8/13
 */
public class QueueImpl<E> implements Queue<E> {

    private LinkedList<E> list = new LinkedList<E>();

    public void add(E e) {
        list.add(e);
    }

    public E peek() {
        if (list.isEmpty()) {
            return null;
        }
        E e =list.removeFirst();
        return e;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
