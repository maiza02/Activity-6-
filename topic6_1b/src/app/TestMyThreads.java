package app;
//Maiza Falcon Rojas
//CST-239
//03/05/2024
//This coded is from Assignment Activity 6 Word Doc Part 1B

/**
 * The TestMyThreads class demonstrates the creation and execution of threads in Java.
 * It includes examples of creating and starting threads that extend the Thread class
 * and implement the Runnable interface.
 */
public class TestMyThreads {

    /**
     * The main method serves as the entry point of the program.
     *
     * @param args The command-line arguments passed to the program.
     */
    public static void main(String[] args) {

        // Example of how to create and start a thread that extends the Thread class
        MyThread1 thread1 = new MyThread1();
        thread1.start();

        // Example of how to create and start a thread that implements the Runnable interface
        Runnable runnable = new MyThread2();
        Thread thread2 = new Thread(runnable);
        thread2.start();
    }
}