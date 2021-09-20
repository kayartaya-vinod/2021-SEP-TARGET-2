package co.vinod.training.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class DaemonThreadDemo {

    @SneakyThrows
    static void delay(long duration) {
        Thread.sleep(duration);
    }

    public static void main(String[] args) {
        Runnable target = () -> {
            for (; ; ) {
                log.debug("from inside Runnable.run() at {}", new Date());
                delay(500);
            }
        };


        Thread t = new Thread(target);
        // we want thread "t" to die when the main thread (non-daemon threads) dies.
        t.setDaemon(true);
        t.start();


        for (int i = 1; i <= 10; i++) {
            delay(500);
            log.debug("from inside main() at {}", new Date());
        }

    }
}
