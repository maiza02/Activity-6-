package app;
//Maiza Falcon Rojas
//CST-239
//03/05/2024
//This coded is from Assignment Activity 6 Word Doc Part 1C


/**
 * The Counter class contains a static counter and methods to increment and get the counter value.
 */
public class Counter {

    // Static counter that starts at zero
    static int count = 0;

    /**
     * Increments the shared counter in a synchronized manner.
     */
    static synchronized void increment() {
        count = count + 1;
    }

    /**
     * Gets the current value of the shared counter.
     *
     * @return The current value of the counter.
     */
    static int getCount() {
        return count;
    }
}