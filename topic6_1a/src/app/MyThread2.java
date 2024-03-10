package app;
//Maiza Falcon Rojas
//CST-239
//03/05/2024
//This coded is from Assignment Activity 6 Word Doc Part 1A

/**
 * The MyThread2 class implements the Runnable interface and provides an example
 * of a simple thread that prints a message when it is running.
 */
public class MyThread2 implements Runnable {

    /**
     * The run method, required by the Runnable interface, defines the code
     * to be executed when the thread is started.
     */
    public void run() {
        System.out.println("MyThread2 is running");
    }
}
