package app;
//Maiza Falcon Rojas
//CST-239
//03/05/2024
//This coded is from Assignment Activity 6 Word Doc Part 1B

import java.lang.Thread;



/**
 * The MyThread1 class extends the Thread class and provides an example
 * of a simple thread that prints a message and sleeps in iterations.
 */
public class MyThread1 extends Thread {

    /**
     * The run method, overridden from the Thread class, defines the code
     * to be executed when the thread is started.
     */
    public void run() {
        for (int x = 0; x < 1000; ++x) {
            System.out.println("MyThread1 is running iteration " + x);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}