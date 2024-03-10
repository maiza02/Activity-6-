package app;
//Maiza Falcon Rojas
//CST-239
//03/05/2024
//This coded is from Assignment Activity 6 Word Doc Part 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * The Client class represents a simple client that connects to a remote server on a specified IP address and port.
 * It communicates with the server by sending and receiving messages through input and output streams.
 * The client can send messages to the server and receive responses until it decides to shut down the connection.
 */
public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    /**
     * Connects to the remote server on the specified IP Address and Port.
     *
     * @param ip   The IP address of the remote server.
     * @param port The port on which the remote server is listening.
     * @throws UnknownHostException If the IP address of the host could not be determined.
     * @throws IOException          If an I/O error occurs during client setup.
     */
    public void start(String ip, int port) throws UnknownHostException, IOException {
        // Connect to the Remote Server on the specified IP Address and Port
        clientSocket = new Socket(ip, port);

        // Create some input and output network buffers to communicate back and forth with the server
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    /**
     * Sends a message to the server and receives the response.
     *
     * @param msg The message to be sent to the server.
     * @return The response received from the server.
     * @throws IOException If an I/O error occurs during message sending or receiving.
     */
    public String sendMessage(String msg) throws IOException {
        // Send/Print a message to the server with a terminating line feed
        out.println(msg);

        // Return the response from the server
        return in.readLine();
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
    }

    /**
     * The main method creates an instance of the Client, connects to the remote server,
     * sends 10 messages to the server, and then cleans up resources on exit.
     *
     * @param args The command-line arguments.
     * @throws IOException If an I/O error occurs during client setup, message sending, or cleanup.
     */
    public static void main(String[] args) throws IOException {
        // Create a Client and connect to the remote Server on the specified IP Address and Port
        Client client = new Client();
        client.start("127.0.0.1", 6666);

        // Send 10 Messages to the Server
        String response;
        for (int count = 0; count < 10; ++count) {
            // Send Message to the server and in the 9th one send a Shutdown Command to the server
            String message;
            if (count != 9)
                message = "Hello from Client" + count;
            else
                message = ".";
            response = client.sendMessage(message);

            // Print out the server response and if we get a Quit response exit this program
            System.out.println("Server response was " + response);
            if (response.equals("Quit"))
                break;
        }
        // On exit, clean everything up
        client.cleanup();
    }
}