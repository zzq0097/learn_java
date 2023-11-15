package com.zzq.learn.thread;

public class LockPrint {
    private final static Object lock = new Object();
    private final static int n = 100;
    private static int count = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                synchronized (lock) {
                    while (count <= n) {
                        if (count % 2 == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + count);
                            count++;
                            lock.notifyAll();
                        } else {
                            lock.wait();
                        }
                    }
                }
            } catch (Exception e) {
            }
        }, "A");
        Thread t2 = new Thread(() -> {
            try {
                synchronized (lock) {
                    while (count <= n) {
                        if (count % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + count);
                            count++;
                            lock.notifyAll();
                        } else {
                            lock.wait();
                        }
                    }
                }
            } catch (Exception e) {
            }
        }, "B");

        t1.start();
        t2.start();
    }
}
