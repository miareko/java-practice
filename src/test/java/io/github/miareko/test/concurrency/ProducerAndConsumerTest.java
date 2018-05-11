package io.github.miareko.test.concurrency;

import io.github.miareko.samples.concurrency.producerandconsumer.LockCondition;
import io.github.miareko.samples.concurrency.producerandconsumer.WaitNotify;
import org.junit.Test;

/**
 * Created by miareko on 2018/5/12.
 */
public class ProducerAndConsumerTest {

    @Test
    public void testWaitNotify() {
        Thread p = new Thread(new WaitNotify.Producer());
        Thread c = new Thread(new WaitNotify.Consumer());
        p.start();
        c.start();
        try {
            p.join();
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLockCondition() {
        Thread p = new Thread(new LockCondition.Producer());
        Thread c = new Thread(new LockCondition.Consumer());
        p.start();
        c.start();
        try {
            p.join();
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
