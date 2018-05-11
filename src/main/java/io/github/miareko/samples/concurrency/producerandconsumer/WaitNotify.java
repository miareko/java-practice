package io.github.miareko.samples.concurrency.producerandconsumer;

/**
 * Created by miareko on 2018/5/12.
 */
public class WaitNotify {


    private static Object lock = new Object();
    private static int c = 0;

    public static class Producer implements Runnable {

        @Override
        public void run() {

            while (true) {
                synchronized (lock) {
                    try {
                        if (c >= 2) {
                            lock.wait();
                        }
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    c++;
                    System.out.println("producer: c = " + c);
                    lock.notify();
                }
            }
        }
    }

    public static class Consumer implements Runnable {

        @Override
        public void run() {

            while (true) {
                synchronized (lock) {
                    try {
                        if (c <= 0) {
                            lock.wait();
                        }
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    c--;
                    System.out.println("consumer: c = " + c);
                    lock.notify();
                }
            }
        }

    }
}
