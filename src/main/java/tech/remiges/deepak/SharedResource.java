package tech.remiges.deepak;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SharedResource {
    // Assuming lines is the only shared resource between threads
    public final BlockingQueue<String> lines = new LinkedBlockingQueue<>();
}
