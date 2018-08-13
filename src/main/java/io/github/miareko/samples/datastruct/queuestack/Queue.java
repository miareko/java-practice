package io.github.miareko.samples.datastruct.queuestack;

/**
 * created by miareko on 2018/8/13
 */
public interface Queue<E> {

    void add(E e);

    E peek();

    boolean isEmpty();
}
