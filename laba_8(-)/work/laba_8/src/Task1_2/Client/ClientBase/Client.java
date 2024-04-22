package Task1_2.Client.ClientBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Random;

public class Client{
    private final Socket socket;
    private final PrintWriter out;
    private final int port;

    public Client() throws IOException {
        Random random = new Random();
        this.port = 46001 + random.nextInt(999);

        this.socket = new Socket();
        SocketAddress localAddress = new InetSocketAddress(this.port);
        SocketAddress remoteAddress = new InetSocketAddress(InetAddress.getLocalHost(), 46000);
        
        this.socket.bind(localAddress);
        this.socket.connect(remoteAddress);

        this.out = new PrintWriter(socket.getOutputStream(), true);

        new Thread(this::receiveMessages).start();

        System.out.println("Client port: " + this.port);
    }

    public void sendMessage(String text, int targetPort) {
        String message = targetPort + ":" + text;
        out.println(message);
    }

    public void receiveMessages() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received message: " + message);
            }
        } catch (IOException e) {
            System.out.println("Error reading from socket: " + e.getMessage());
        }
    }
}