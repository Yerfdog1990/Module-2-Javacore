package SocketServer;
import java.io.*;
import java.net.*;

/**
 * A simple server application that listens for incoming client connections,
 * receives a message from the client, and sends a response back before closing the connection.
 */
public class GreetingServer extends Thread {
    private final ServerSocket serverSocket;

    /**
     * Constructor to create a server socket bound to a specific port.
     * @param portNumber The port number on which the server should listen for incoming connections.
     * @throws IOException If an I/O error occurs during socket creation.
     */
    public GreetingServer(int portNumber) throws IOException {
        serverSocket = new ServerSocket(portNumber);
        serverSocket.setSoTimeout(10000); // Timeout set to 10 seconds for accepting connections.
    }
    /**
     * Thread entry point. Continuously waits for client connections,
     * processes received messages, and sends acknowledgments.
     */
    @Override
    public void run() {
        while (true) {
            try {
                // Wait for a client connection.
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "....");
                Socket server = serverSocket.accept(); // Accepts the incoming client connection.
                System.out.println("Just got connected to " + server.getRemoteSocketAddress());

                // Read the client's message.
                InputStream inFromClient = server.getInputStream();
                DataInputStream dataIn = new DataInputStream(inFromClient);
                System.out.println("Just got message from client: " + dataIn.readUTF());

                // Send a response back to the client.
                OutputStream outToServer = server.getOutputStream();
                DataOutputStream dataOut = new DataOutputStream(outToServer);
                dataOut.writeUTF(String.format("Thank you for connecting to %s%nGoodbye!", server.getLocalSocketAddress()));

                // Close the connection with the client.
                server.close();
            } catch (SocketTimeoutException s) {
                // Handles socket timeout exception if a connection isn't established in time.
                System.out.println("Socket timed out");
                break;
            } catch (IOException e) {
                // Prints the stack trace for any I/O exceptions.
                e.printStackTrace();
                break;
            }
        }
    }

    /**
     * The main method to run the server.
     * @param args Command-line arguments, where the first argument specifies the port number.
     */
    public static void main(String[] args) {
        // Ensure a port number is provided as an argument.
        int portNumber = 9806;
        try {
            // Start the server as a separate thread.
            Thread t = new GreetingServer(portNumber);
            t.start();
        } catch (IOException e) {
            // Prints the stack trace for any exceptions during server initialization.
            e.printStackTrace();
        }
    }
}
