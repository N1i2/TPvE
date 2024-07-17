package Task1_3.Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {
    private final DatagramSocket socket;

    public Client(int i) throws SocketException {
        this.socket = new DatagramSocket(i);
    }

    public void SendMessage(String text, int i) throws IOException{
        DatagramPacket message = new DatagramPacket(text.getBytes(), text.getBytes().length, InetAddress.getLocalHost(), i);
        socket.send(message);
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client(45005);

        client.SendMessage("Hello friend!!!", 45000);
        client.SendMessage("How are you?", 45000);
        client.SendMessage("Im fine, and you?", 45000);
        client.SendMessage("Ok, By by!!!", 45000);
    }
}