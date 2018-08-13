package io.github.miareko.samples.datastruct.queuestack;


/**
 * 两个队列实现栈
 * created by miareko on 2018/8/13
 */
public class DoubleQueueStack<E> implements Stack<E> {

    private Queue<E> q1 = new QueueImpl<E>();
    private Queue<E> q2 = new QueueImpl<E>();

    public void push(E e) {
        if (q1.isEmpty()) {
            q1.add(e);
            merge(q2, q1);
        } else {
            q2.add(e);
            merge(q1, q2);
        }
    }

    public E pop() {
        if (!q1.isEmpty()) {
            return q1.peek();
        }
        return q2.peek();
    }

    private void merge(Queue<E> from, Queue<E> to) {
        while (!from.isEmpty()) {
            to.add(from.peek());
        }
    }

    @Override
    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

}
