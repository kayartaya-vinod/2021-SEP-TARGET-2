package co.vinod.training.entity;

import java.io.Closeable;
import java.io.IOException;

public class Dummy implements Closeable {
    public void close() throws IOException {
        System.out.println("Dummy object closing...");
    }
}
