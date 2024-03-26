package tech.remiges;

import tech.remiges.deepak.CounterThread;
import tech.remiges.deepak.ReaderThread;
import tech.remiges.deepak.SharedResource;

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
        SharedResource sharedResource = new SharedResource();
        ReaderThread readerThread = new ReaderThread(
                "/home/deepakk/Desktop/workSpace/WorkAccess/src/main/java/tech/remiges/deepak/input.txt",
                sharedResource);
        CounterThread counterThread = new CounterThread(sharedResource);

        readerThread.start();
        counterThread.start();

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
