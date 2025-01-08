package SocketClient;

import java.io.*;
import java.net.*;

// This class implements a simple client that connects to a server, sends a greeting, and receives a response
public class GreetingClient {
    public static void main(String[] args) {
        // Get server name and port number from command-line arguments
        String serverName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        try {
            // Establish a connection to the specified server and port
            System.out.printf("Connecting %s on server port %d%n", serverName, portNumber);
            Socket client = new Socket(serverName, portNumber);
            System.out.printf("Just got connected to %s%n", client.getRemoteSocketAddress());

            // Send a greeting message to the server
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream dataOut = new DataOutputStream(outToServer);
            dataOut.writeUTF(String.format("Greeting from %s%n", client.getLocalSocketAddress()));

            // Receive and display the server's response
            InputStream inFromServer = client.getInputStream();
            DataInputStream dataIn = new DataInputStream(inFromServer);
            System.out.printf("Just got message from server: %s%n", dataIn.readUTF());
            client.close();
        } catch (IOException e) {
            // Handle any input/output errors that occur during communication
            throw new RuntimeException(e);
        }
    }
}
