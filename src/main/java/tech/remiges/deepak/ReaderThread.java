package tech.remiges.deepak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class ReaderThread implements Runnable {
    private final String filePath;
    private final BlockingQueue<String> queue;

    public ReaderThread(String filePath, BlockingQueue<String> queue) {
        this.filePath = filePath;
        this.queue = queue;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                queue.put(line); // This will block if the queue is full
            }
            queue.put("EOF"); // Indicates the end of file
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
