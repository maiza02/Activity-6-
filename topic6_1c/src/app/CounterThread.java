package app;
//Maiza Falcon Rojas
//CST-239
//03/05/2024
//This coded is from Assignment Activity 6 Word Doc Part 1C

import java.util.Random;


/**
 * The CounterThread class extends Thread and represents a thread that increments a shared counter.
 */
public class CounterThread extends Thread {

    /**
     * The run method, overridden from the Thread class, defines the code
     * to be executed when the thread is started. It sleeps for a random amount,
     * increments the shared counter, and exits the thread.
     */
    public void run() {
        // Sleep this thread for a random amount, increment the counter, and exit this thread
        try {
            Random rand = new Random();
            int sleeper = rand.ints(1, (1000 + 1)).findFirst().getAsInt();
            Thread.sleep(sleeper);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Counter.increment();
    }
}