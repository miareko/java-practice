package io.github.miareko.samples.datastruct.queuestack;

/**
 * created by miareko on 2018/8/13
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    boolean isEmpty();
}
