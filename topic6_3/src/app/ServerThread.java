package app;
//Maiza Falcon Rojas
//CST-239
//03/06/2024
//This coded is from Assignment Activity 6 Word Doc Part 3

import java.io.IOException;

/**
 * The ServerThread class extends Thread and represents a separate thread
 * responsible for starting and running an instance of the Server.
 */
public class ServerThread extends Thread {

    /**
     * The run method, overridden from the Thread class, defines the code
     * to be executed when the thread is started. It creates an instance of
     * the Server, starts it on port 6666, and cleans up on exit.
     */
    public void run() {
        // Create an instance of a Server
        // Start the Server on port 6666 (which will not return until the Shutdown Command is received)
        // and then on exit clean everything up which will exit this thread
        Server server = new Server();
        try {
            server.start(6666);
            server.cleanup();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
