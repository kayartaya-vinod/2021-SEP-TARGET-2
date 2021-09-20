package co.vinod.training.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadBasicDemo {

    static void print(String msg){
        log.debug("msg = {}", msg);
    }

    public static void main(String[] args) {

        Thread t = new Thread() {
            @Override
            public void run() {
                for(int i=1; i<=10; i++){
                    print("from thread's run()");
                }
            }
        };

        t.start();
        // 1. this is an instruction to the scheduler
        // 2. a new stack is created
        // 3. the t.run() function is placed in the stack as a stack frame
        // 4. the thread goes to a state called "runnable" and wait for its turn to become a running thread
        // 5. when the state a thread is "running", the code in "run()" is called,
        // 6. once the time is up, the thread goes back to "runnable" state
        // 7. once the run() is complete, the thread is considered to be "dead"

        for(int i=1; i<=10; i++){
            print("from main");
        }
    }
}
