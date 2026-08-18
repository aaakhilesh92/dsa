package thread;

public class MyBlockingQueue2<E> {
    private int length = 10;
    final Object[] items;
    public MyBlockingQueue2(int capacity) {
        length = capacity;
        items = new Object[length];
    }

    public MyBlockingQueue2() {
        items = new Object[length];
    }

    int putptr, takeptr, count;

    public synchronized void put(E x) throws InterruptedException {
        while (count == items.length)
            wait();
        items[putptr] = x;
        if (++putptr == items.length)
            putptr = 0;
        ++count;
        notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        while (count == 0)
            wait();
        Object x = items[takeptr];
        if (++takeptr == items.length)
            takeptr = 0;
        --count;
        notifyAll();
        return ((E) x);
    }
}
