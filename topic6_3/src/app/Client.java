package app;
//Maiza Falcon Rojas
//CST-239
//03/06/2024
//This coded is from Assignment Activity 6 Word Doc Part 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * The Client class represents a simple client that connects to a remote server using sockets.
 * It sends messages to the server and receives responses.
 */
public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    /**
     * Connects to the remote server on the specified IP address and port.
     *
     * @param ip   The IP address of the remote server.
     * @param port The port on which the client will connect to the server.
     * @throws UnknownHostException If the IP address of the host could not be determined.
     * @throws IOException          If an I/O error occurs while connecting to the server.
     */
    public void start(String ip, int port) throws UnknownHostException, IOException {
        // Connect to the remote server on the specified IP address and port
        clientSocket = new Socket(ip, port);

        // Create input and output network buffers to communicate with the server
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    /**
     * Sends a message to the server and receives the response.
     *
     * @param msg The message to be sent to the server.
     * @return The response received from the server.
     * @throws IOException If an I/O error occurs while sending or receiving messages.
     */
    public String sendMessage(String msg) throws IOException {
        // Send/print a message to the server with a terminating line feed
        out.println(msg);

        // Return the response from the server
        return in.readLine();
    }

    /**
     * Closes all input and output network buffers and the socket.
     *
     * @throws IOException If an I/O error occurs while closing the buffers and socket.
     */
    public void cleanup() throws IOException {
        // Close all input and output network buffers and the socket
        in.close();
        out.close();
        clientSocket.close();
    }

    /**
     * The main method creates a client, connects to the remote server on the specified IP address and port,
     * sends 10 messages to the server, and cleans up everything on exit.
     *
     * @param args The command-line arguments (not used in this implementation).
     * @throws IOException          If an I/O error occurs while starting, sending messages, or cleaning up the client.
     * @throws InterruptedException If the sleep is interrupted.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // Create a client and connect to the remote server on the specified IP address and port
        Client client = new Client();
        client.start("127.0.0.1", 6666);

        // Send 10 messages to the server
        String response;
        for (int count = 0; count < 10; ++count) {
            // Send a message to the server and in the 9th one send a shutdown command to the server
            String message;
            if (count != 9)
                message = "Hello from Client" + count;
            else
                message = ".";
            response = client.sendMessage(message);

            // Print out the server response and exit this program if a Quit response is received
            System.out.println("Server response was " + response);
            if (response.equals("QUIT"))
                break;

            // Sleep for a bit so the server can run for a while
            Thread.sleep(5000);
        }
        // On exit, clean everything up
        client.cleanup();
    }
}