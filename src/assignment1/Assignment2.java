package assignment1;

public class Assignment2 {
    public static int store = 2;


    //no assumption about order execution of each thread!
    public static void main(String[] args) {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> System.out.println(Thread.currentThread().getName() + " :isdhsd"));
            threads[i].start();
        }

    }
}
