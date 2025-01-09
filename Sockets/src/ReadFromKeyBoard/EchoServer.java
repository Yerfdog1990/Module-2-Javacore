package ReadFromKeyBoard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try {
            System.out.println("Waiting for client connection...");
            ServerSocket serverSocket = new ServerSocket(6666);
            Socket soc = serverSocket.accept();
            System.out.println("Connection established");
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String message = in.readLine();
            System.out.println(message);
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println("Server says " +message);
            soc.close();
            serverSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
