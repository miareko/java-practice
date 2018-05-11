package io.github.miareko.samples.concurrency.producerandconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class LockCondition {


    private static int c = 0;
    private static Lock lock = new ReentrantLock();
    private static Condition notEmpty = lock.newCondition();
    private static Condition notFull = lock.newCondition();

    public static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (c >= 2) {
                        notFull.await();
                    }
                    Thread.sleep(1000);
                    c++;
                    System.out.println("producer: c = " + c);
                    notEmpty.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

    }

    public static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (c <= 0) {
                        notEmpty.await();
                    }
                    Thread.sleep(1000);
                    c--;
                    System.out.println("consumer: c = " + c);
                    notFull.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

    }
}
