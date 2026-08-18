package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
    private final int nThreads;
    private final Thread[] threads;
    private final BlockingQueue<Runnable> queue;

    public CustomThreadPool(int nThreads) {
        this.nThreads = nThreads;
        queue = new LinkedBlockingQueue<Runnable>();
        threads = new PoolWorker[nThreads];

        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker("Custom Pool Thread " + i);
            threads[i].start();
        }
    }

    public void execute(Runnable task) {
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class PoolWorker extends Thread {
        public PoolWorker(String name) {
            super(name);
        }

        public void run() {
            while (true) {
                // If we don't catch RuntimeException, the pool could leak threads
                try {
                    queue.take().run();
                } catch (RuntimeException e) {
                    System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}