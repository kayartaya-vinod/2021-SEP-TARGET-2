package co.vinod.training.programs;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Slf4j
public class ProblemWithSharedResourceDemo {

    @AllArgsConstructor
    static class FileProcessor {
        private String filename;

        @SneakyThrows
        public  void readAndStore(List<String> list) {
            try (FileReader reader = new FileReader(filename);
                 BufferedReader in = new BufferedReader(reader)) {
                String line;
                while ((line = in.readLine()) != null) {
                    synchronized (list) {
                        list.add(line);
                    }
                }
            }
        }
    }

    @SneakyThrows
    static void threadJoin(Thread t){
        t.join();
    }

    @SneakyThrows
    public static void main(String[] args) {
        List<String> sharedList = new ArrayList<>(); // Vector is a better fit here
        List<Thread> threads = new ArrayList<>();

        String[] filenames = {"f1.txt", "f2.txt", "f3.txt"};
        for(String filename: filenames){
            Thread t = new Thread(()->new FileProcessor(filename).readAndStore(sharedList));
            threads.add(t);
            t.start();
        }

        // we want all threads to finish their work, and only then we want to go forward from here:
        threads.forEach(ProblemWithSharedResourceDemo::threadJoin);

        System.out.println("Content of sharedList is: ");
        sharedList.forEach(System.out::println);
    }
}
