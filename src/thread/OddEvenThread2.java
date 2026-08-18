package thread;

class Printer2 {
    private volatile boolean isOdd = true;
    final private int limit;
    public Printer2(int limit) {
        this.limit = limit;
    }
    public synchronized void printOdd(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = false;
        notify();
    }

    public synchronized void printEven(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = true;
        notify();
    }

}
class TaskEvenOdd implements Runnable {
    final private Printer2 printer;
    private boolean isOdd;
    final private int limit;
    TaskEvenOdd(Printer2 printer, int limit, boolean isOdd) {
        this.limit = limit;
        this.printer = printer;
        this.isOdd = isOdd;
    }
    // standard constructors

    @Override
    public void run() {
        int number = isOdd ? 1 : 2;
        while (number <= limit) {
            if (isOdd) {
                printer.printOdd(number);
            } else {
                printer.printEven(number);
            }
            number += 2;
        }
    }
}

public class OddEvenThread2 {
    public static void main(String[] args) {
        Printer2 print = new Printer2(10);
        Thread t1 = new Thread(new TaskEvenOdd(print, 10, true), "Odd");
        Thread t2 = new Thread(new TaskEvenOdd(print, 10, false), "Even");
        t1.start();
        t2.start();
    }
}
