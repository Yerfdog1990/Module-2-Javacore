package SocketClient;

import java.io.*;
import java.net.*;

public class GreetingClient {
    public static void main(String[] args) {
        String serverName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        try {
            System.out.printf("Connecting %s on server port %d%n", serverName, portNumber);
            Socket client = new Socket(serverName, portNumber);
            System.out.printf("Just got connected to %s%n", client.getRemoteSocketAddress());

            OutputStream outToServer = client.getOutputStream();
            DataOutputStream dataOut = new DataOutputStream(outToServer);
            dataOut.writeUTF(String.format("Greeting from %s%n", System.getProperty("user.name")));

            InputStream inFromServer = client.getInputStream();
            DataInputStream dataIn = new DataInputStream(inFromServer);
            System.out.printf("Just got message from server: %s%n", dataIn.readUTF());
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
