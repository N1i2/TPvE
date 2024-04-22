package Task1_3.Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    private final DatagramSocket socket;

    public Server(int i) throws SocketException{
        socket = new DatagramSocket(i);
    }

    public String getMessage() throws IOException{
        int size = 20;
        byte[] messUDP = new byte[size];
        socket.receive(new DatagramPacket(messUDP, size));
        StringBuilder mess = new StringBuilder();

        for(var symbol:messUDP){
            if(symbol != 0){
                mess.append((char) symbol);
            }
        }

        return mess.toString();
    }

    public static void main(String[] args) throws IOException {
        Server UDP = new Server(45000);

        while (0 == 0){
            System.out.println(UDP.getMessage());
        }
    }
}
