package tech.remiges;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import tech.remiges.deepak.CounterThread;
import tech.remiges.deepak.ReaderThread;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("you can change code and then commit.");
        System.out.println("please change line or add new line");
        System.out.println("Code changed by Suraj");

        System.out.println("Code2 changed by Suraj");

        System.out.println("hello developer");

        System.out.println("Reshma");
        System.out.println("Yogesh");

        System.out.println("hi Rajesh ");

        // Added by Deepak for Thread part

        final BlockingQueue<String> queue = new LinkedBlockingQueue<>(10); // Capacity can be adjusted
        final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        String filePath = "/home/deepakk/Desktop/workSpace/WorkAccess/src/main/java/tech/remiges/deepak/input.txt";

        // Start reader thread
        new Thread(new ReaderThread(filePath, queue)).start();

        // Start counter threads
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            executor.submit(new CounterThread(queue));
        }

        executor.shutdown();

        // Thread part over

    }

    public String getName1() {
        return "Deepak";
    }

    // Code by Shivendra
    public String getName2() {
        return "Shivendra";
    }

    public String getName() {
        return "Suraj";

    }
}
