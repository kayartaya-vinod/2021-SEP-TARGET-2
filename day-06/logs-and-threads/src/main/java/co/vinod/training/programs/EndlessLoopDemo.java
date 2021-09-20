package co.vinod.training.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EndlessLoopDemo {

    static class Person {
        private String name;
        private String city;
        private String email;
    }

    static void foo() {
        log.debug("foo() called");
        Person p = new Person();
        log.debug("calling bar()");
        bar();
        log.debug("returned from bar()");
    }

    static void bar() {
        log.debug("bar() called");
    }

    public static void main(String[] args) {

        for (; ; ) {
            foo();
        }
    }
}
