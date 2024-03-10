package app;
//Maiza Falcon Rojas
//CST-239
//03/05/2024
//This coded is from Assignment Activity 6 Word Doc Part 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



/**
 * The Server class represents a simple server that listens for client connections on a specified port.
 * It communicates with the connected client by sending and receiving messages through input and output streams.
 * The server can be shut down by receiving a special command from the client.
 */
public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    /**
     * Starts the server on the specified port, waiting for a client connection.
     *
     * @param port The port on which the server will listen for client connections.
     * @throws IOException If an I/O error occurs during server setup or communication.
     */
    public void start(int port) throws IOException {
        // Wait for a client connection
        System.out.println("Waiting for a Client connection........");
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();

        // If you get here, then a Client connected to this Server, so create some input and output network buffers
        System.out.println("Received a Client connection on port " + clientSocket.getLocalPort());
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Wait for Command (a string that is terminated by a line feed character)
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            // If period command then shut the Server down
            if (".".equals(inputLine)) {
                System.out.println("Got a message to shut the Server down");
                out.println("Quit");
                break;
            } else {
                // Echo an acknowledgment back to the Client that the command was processed successfully
                System.out.println("Got a message of: " + inputLine);
                out.println("OK");
            }
        }
        // Exit message that Server is shut down
        System.out.println("Server is shut down");
    }

    /**
     * Cleans up resources by closing all input and output network buffers and sockets.
     *
     * @throws IOException If an I/O error occurs during cleanup.
     */
    public void cleanup() throws IOException {
        // Close all input and output network buffers and sockets
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    /**
     * The main method creates an instance of the Server, starts it on a specified port,
     * and then cleans up resources after the server is shut down.
     *
     * @param args The command-line arguments.
     * @throws IOException If an I/O error occurs during server setup or cleanup.
     */
    public static void main(String[] args) throws IOException {
        // Create an instance of this Server
        // Start the server on port 6666 (which will not return until the Shutdown Command is received)
        // and then on exit clean everything up
        Server server = new Server();
        server.start(6666);
        server.cleanup();
    }
}