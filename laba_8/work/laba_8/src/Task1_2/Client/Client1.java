package Task1_2.Client;

import Task1_2.Client.ClientBase.Client;

import java.io.IOException;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) throws IOException {
        Client client = new Client();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter target client port: ");
            int targetPort = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter message: ");
            String message = scanner.nextLine();
            client.sendMessage(message, targetPort);
        }
    }
}