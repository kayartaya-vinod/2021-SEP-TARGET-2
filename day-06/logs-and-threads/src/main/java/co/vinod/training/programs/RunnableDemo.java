package co.vinod.training.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableDemo {

    public static void main(String[] args) {

        Runnable target = () -> {
            for (int i = 1; i <= 10; i++) {
                log.debug("inside target.run(), i is {}", i);
            }
        };

        Thread t1 = new Thread(target);
        t1.start();
        // when t1 is pushed to "running" state, t1.run() is called, which calls target.run();

        for(int j=100; j<=110; j++){
            log.debug("inside main(), j is {}", j);
        }
    }
}
