package assignment1;

class Counter {
    private int c = 0;

    public synchronized void increment() {
        int b = c;
        b = b + 1;
        c = b;
    }

    public synchronized void decrement() {
        int d = c;
        d = d - 1;
        c = d;
    }

    public synchronized int value() {
        return c;
    }
}