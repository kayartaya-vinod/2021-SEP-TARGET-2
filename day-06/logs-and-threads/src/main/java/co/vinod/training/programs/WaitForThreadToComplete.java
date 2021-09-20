package co.vinod.training.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

@Slf4j
public class WaitForThreadToComplete {

    static class FileProcessor {
        @SneakyThrows
        public void process(Reader reader){
            try(BufferedReader in = new BufferedReader(reader)){
                String line;
                while((line=in.readLine())!=null){
                    log.debug("line = {}", line);
                }
            }
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        String filename = "src/main/java/co/vinod/training/programs/EndlessLoopDemo.java";

        try (FileReader file= new FileReader(filename);) {
            Thread t1 = new Thread(() -> {
                FileProcessor fp = new FileProcessor();
                fp.process(file);
            });
            t1.start();

            for(int i=1; i<=5; i++){
                log.debug("main() is ending...");
            }
            log.debug("main() ended!");

            t1.join(); // wait for t1 to finish its job and die.
        } // file.close() is called automatically here.
        // At this time, it is possible, that t1 might have not even started its work.
        // But, when t1 gets into "running" state, it is trying to read from a closed input stream,
        // which is why, we are getting an error.


    }

}
