package app;
//Maiza Falcon Rojas
//CST-239
//03/05/2024
//This coded is from Assignment Activity 6 Word Doc Part 1B


/**
 * The MyThread2 class implements the Runnable interface and provides an example
 * of a simple thread that prints a message and sleeps in iterations.
 */
public class MyThread2 implements Runnable {

    /**
     * The run method, required by the Runnable interface, defines the code
     * to be executed when the thread is started.
     */
    public void run() {
        for (int x = 0; x < 1000; ++x) {
            System.out.println("MyThread2 is running iteration " + x);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}