package io.github.miareko.samples.datastruct.queuestack;

import java.util.ArrayList;
import java.util.List;

/**
 * created by miareko on 2018/8/13
 */
public class StackImpl<E> implements Stack<E> {

    private List<E> list = new ArrayList<E>();

    public void push(E e) {
        list.add(e);
    }

    public E pop() {
        if (list.isEmpty()) {
            return null;
        }
        E e = list.remove(list.size() - 1);
        return e;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
