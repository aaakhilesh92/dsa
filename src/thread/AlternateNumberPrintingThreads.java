package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AlternateNumberPrintingThreads {
    public static void main(String[] args) {
        SharedObject obj = new SharedObject(10);
        PrintSequenceRunnable runnable1 = new PrintSequenceRunnable(obj);
        PrintSequenceRunnable runnable2 = new PrintSequenceRunnable(obj);
        PrintSequenceRunnable runnable3 = new PrintSequenceRunnable(obj);
        PrintSequenceRunnable runnable4 = new PrintSequenceRunnable(obj);

        Thread t1 = new Thread(runnable1, "T0");
        Thread t2 = new Thread(runnable2, "T1");
        Thread t3 = new Thread(runnable3, "T2");
        Thread t4 = new Thread(runnable4, "T3");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class SharedObject {
    final private int max;
    final private AtomicInteger counter;
    final private AtomicInteger threadCount;
    public SharedObject(int max) {
        this.max = max;
        counter = new AtomicInteger(1);
        threadCount = new AtomicInteger(0);
    }
    public int getMax() {
        return max;
    }
    public AtomicInteger getCounter() {
        return counter;
    }
    public AtomicInteger getThreadCount() {
        return threadCount;
    }
}

class PrintSequenceRunnable implements Runnable {
    final private int remainder;
    final private SharedObject obj;

    PrintSequenceRunnable(SharedObject obj) {
        this.obj = obj;
        remainder = obj.getThreadCount().getAndIncrement();
    }

    @Override
    public void run() {
        while (obj.getCounter().get() < obj.getMax() - obj.getThreadCount().get() + 2) {
            synchronized (obj) {
                while (obj.getCounter().get() % obj.getThreadCount().get() != remainder) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + obj.getCounter().getAndIncrement());
                obj.notifyAll();
            }
        }
    }
}