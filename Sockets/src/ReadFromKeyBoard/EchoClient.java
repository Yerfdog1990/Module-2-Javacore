package ReadFromKeyBoard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        try {
            System.out.println("Client started");
            Socket clientSocket = new Socket("localhost", 6666);
            System.out.print("Enter message: ");
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String message = userInput.readLine();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(message);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String response = in.readLine();
            System.out.println(response);
            clientSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}