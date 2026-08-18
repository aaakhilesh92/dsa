package thread;

class Printer {

    // Starting counter
    private int counter = 1;

    final private int limit;
    public Printer(int limit) {
        this.limit = limit;
    }

    public synchronized void printOddNumber() {
        while (counter < limit) {
            while (counter % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " - " + counter);
            counter++;
            notify();
        }
    }

    public synchronized void printEvenNumber() {
        while (counter < limit) {
            while (counter % 2 == 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + " - " + counter);
            counter++;
            notify();
        }
    }
}
public class OddEvenThread {
    public static void main(String[] args) {
        Printer pr = new Printer(10);

        Runnable r1 = () -> pr.printEvenNumber();
        Runnable r2 = () -> pr.printOddNumber();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
