package co.vinod.training.programs;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class LoggingDemo {

    //private static final Logger log = LoggerFactory.getLogger(LoggingDemo.class);

    public static void main(String[] args) {
        log.trace("This is a trace message");
        log.debug("This is a debug message");
        log.info("This is an information message");
        log.warn("This is a warning message");
        log.error("This is an error message");
    }
}
