package app;
//Maiza Falcon Rojas
//CST-239
//03/05/2024
//This coded is from Assignment Activity 6 Word Doc Part 1C

/**
 * The CounterWorker class demonstrates the use of multiple threads to increment a counter.
 * It creates a specified number of CounterThread instances and starts them in separate threads.
 * The main method then waits for a subset of CounterThread instances to finish and prints
 * the final value of the shared Counter.
 */
public class CounterWorker {

    /**
     * The main method serves as the entry point of the program.
     *
     * @param args The command-line arguments passed to the program.
     * @throws InterruptedException If any thread interrupts the current thread.
     */
    public static void main(String args[]) throws InterruptedException {

        // Print start message
        System.out.println("This is the initial value of the Counter " + Counter.getCount());

        // Number of Counters to create
        int numberCounters = 1000;

        // Create 1000 Counters that can each run in their own thread
        CounterThread[] counters = new CounterThread[numberCounters];
        for (int x = 0; x < 1000; ++x)
            counters[x] = new CounterThread();

        // Start all 1000 Counter threads
        for (int x = 0; x < 1000; ++x)
            counters[x].start();

        // Wait for 100 Counter threads to finish
        for (int x = 0; x < 1000; ++x)
            counters[x].join();

        // What value did the Counter end up with?
        System.out.println("This is the end value of the Counter " + Counter.getCount());
    }
}
