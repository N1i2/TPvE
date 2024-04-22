package Task1_2.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private final ServerSocket serverSocket;
    private Map<Integer, Socket> clients;
    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.clients = new HashMap<>();
    }

    public void acceptClients() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            int clientPort = clientSocket.getPort();

            System.out.println("Message received client "+clientPort);

            if (!clients.containsKey(clientPort)) {
                clients.put(clientPort, clientSocket);
            }

            new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String message;
                    while ((message = in.readLine()) != null) {
                        String[] parts = message.split(":", 2);
                        int targetPort = Integer.parseInt(parts[0]);
                        String targetMessage = parts[1];

                        if (clients.containsKey(targetPort)) {
                            PrintWriter out = new PrintWriter(clients.get(targetPort).getOutputStream(), true);

                            System.out.println("Message from "+ clientPort + " to " + targetPort);

                            out.println(targetMessage);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error handling client: " + e.getMessage());
                }
            }).start();
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(46000);
        server.acceptClients();
    }
}
