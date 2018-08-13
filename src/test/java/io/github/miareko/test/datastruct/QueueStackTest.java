package io.github.miareko.test.datastruct;

import io.github.miareko.samples.datastruct.queuestack.DoubleQueueStack;
import io.github.miareko.samples.datastruct.queuestack.Stack;
import org.junit.Assert;
import org.junit.Test;

/**
 * created by miareko on 2018/8/13
 */
public class QueueStackTest {

    @Test
    public void testDoubleQueueStack() {
        Stack<Integer> stack = new DoubleQueueStack<>();
        stack.push(1);
        stack.push(2);
        Assert.assertTrue(stack.pop() == 2);
        stack.push(3);
        Assert.assertTrue(stack.pop() == 3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        Assert.assertTrue(stack.pop() == 6);
        Assert.assertTrue(stack.pop() == 5);
        Assert.assertTrue(stack.pop() == 4);
        Assert.assertTrue(stack.pop() == 1);
    }
}
