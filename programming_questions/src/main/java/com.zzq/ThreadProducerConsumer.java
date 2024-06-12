package com.zzq;

/**
 * 使用两个线程模拟生产者消费者
 */
public class ThreadProducerConsumer {
    public static void main(String[] args) {
        final Buffer buffer = new Buffer();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                buffer.produce(i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(buffer.consume());
            }
        }).start();
    }
}


class Buffer {
    Object data;
    boolean empty = true;

    public synchronized void produce(Object data) {
        if (!empty) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        empty = false;
        this.data = data;
        notify();
    }

    public synchronized Object consume() {
        if (empty) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        empty = true;
        notify();
        return data;
    }
}
