package app;
//Maiza Falcon Rojas
//CST-239
//03/06/2024
//This coded is from Assignment Activity 6 Word Doc Part 3

/**
 * The ServerApp class represents the main application that creates and starts
 * an instance of the ServerThread, periodically checks its status, and prints
 * dots until the ServerThread finishes its execution.
 */
public class ServerApp {

    /**
     * The main method serves as the entry point of the program.
     *
     * @param args The command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        // Create an instance of ServerThread
        ServerThread serverThread = new ServerThread();

        // Start the ServerThread
        serverThread.start();

        // Enter a loop while the thread is still running
        while (serverThread.isAlive()) {
            System.out.print(".");
            try {
                // Sleep for 5 seconds
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Thread has finished, print a newline for clarity
        System.out.println();
    }
}