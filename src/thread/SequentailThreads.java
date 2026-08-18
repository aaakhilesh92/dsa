package thread;

public class SequentailThreads {

    public static void main(String[] args) {
        Runnable r1 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Executing thread " + Thread.currentThread().getName() + " - End");
        };
        MyThread t1 = new MyThread(r1);
        MyThread t2 = new MyThread(t1, r1);
        MyThread t3 = new MyThread(t2, r1);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("thread " + Thread.currentThread().getName() + " finished");
    }
}

class MyThread extends Thread {

    Thread anotherThread;
    Runnable task;

    MyThread(Thread anotherThread, Runnable task) {
        this.anotherThread = anotherThread;
        this.task = task;
    }

    MyThread(Runnable task) {
        this.task = task;
    }

    public void run() {
        try {
            if (anotherThread != null) {
                anotherThread.join();
            }
            System.out.println("Executibg thread " + Thread.currentThread().getName() + " - Start");
            Thread.sleep(1000);
            task.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}