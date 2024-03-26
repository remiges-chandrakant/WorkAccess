package tech.remiges.deepak;

import java.util.concurrent.BlockingQueue;

public class CounterThread implements Runnable {
    private final BlockingQueue<String> queue;

    public CounterThread(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String line = queue.take();
                if ("EOF".equals(line)) {
                    queue.put("EOF"); // Put it back for other counters to see
                    break;
                }
                int wordCount = line.split("\\s+").length;
                System.out.println(
                        Thread.currentThread().getName() + " counted " + wordCount + " words in line: " + line);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
