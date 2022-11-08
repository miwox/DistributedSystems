package assignment1;

public class Assignment4 {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                final int times = 10000;
                for(int j = 0; j < times; j++){
                    counter.increment();
                    counter.decrement();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) thread.join();

        System.out.println(counter.value());

    }
}