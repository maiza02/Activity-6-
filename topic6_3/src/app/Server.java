package app;
//Maiza Falcon Rojas
//CST-239
//03/06/2024
//This coded is from Assignment Activity 6 Word Doc Part 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The Server class represents a simple server that waits for a client connection,
 * processes incoming commands, and acknowledges successful command processing.
 * It uses sockets for communication.
 */
public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    /**
     * Starts the server on the specified port, waits for a client connection,
     * processes incoming commands, and shuts down the server when a specific command is received.
     *
     * @param port The port on which the server will listen for client connections.
     * @throws IOException If an I/O error occurs while setting up the server.
     */
    public void start(int port) throws IOException {
        // Wait for a client connection
        System.out.println("Waiting for a Client connection........");
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();

        // If you get here, then a client connected to this server, so create input and output network buffers
        System.out.println("Received a Client connection on port " + clientSocket.getLocalPort());
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Wait for a command (string that is terminated by a line feed character)
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            // If the command is ".", shut down the server
            if (".".equals(inputLine)) {
                System.out.println("Got a message to shut the Server down");
                out.println("QUIT");
                break;
            } else {
                // Echo an acknowledgment back to the client that the command was processed successfully
                System.out.println("Got a message of: " + inputLine);
                out.println("OK");
            }
        }
        // Exit message that the server is shut down
        System.out.println("Server is shut down");
    }

    /**
     * Closes all input and output network buffers and sockets.
     *
     * @throws IOException If an I/O error occurs while closing the buffers and sockets.
     */
    public void cleanup() throws IOException {
        // Close all input and output network buffers and sockets
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    /**
     * The main method creates an instance of this server, starts the server on port 6666,
     * and then cleans up everything on exit.
     *
     * @param args The command-line arguments (not used in this implementation).
     * @throws IOException If an I/O error occurs while starting or cleaning up the server.
     */
    public static void main(String[] args) throws IOException {
        // Create an instance of this server
        // Start the server on port 6666 (which will not return until the shutdown command is received)
        // and then on exit clean everything up
        Server server = new Server();
        server.start(6666);
        server.cleanup();
    }
}
