package Start;

import acter.*;
import resurs.AllProblems;

import java.io.File;
import java.io.IOException;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("test", 0));
        clients.removeFirst();

        String name;
        int problem;

        System.out.print("If you want to take clients from program press 1: ");
        name = new Scanner(System.in).next();

        if(name.equals("1")){
            clients.add(new Client("nikola",1));
            clients.add(new Client("julia",2));
            clients.add(new Client("masha",3));
            clients.add(new Client("tolik",4));
            clients.add(new Client("ivan",5));
            clients.add(new Client("stas",1));
            clients.add(new Client("nikita",5));
            clients.add(new Client("ura",2));
            clients.add(new Client("egor",4));
            clients.add(new Client("matvei",3));
        }
        else{
            while(true){
                System.out.print("Enter your name(for end enter 0(ziro)): ");
                name = new Scanner(System.in).next();

                if(name.equals("0")){
                    break;
                }

                AllProblems.ShowProblem();
                System.out.print("Enter your problem number: ");

                try {
                    problem = new Scanner(System.in).nextInt();
                    if(problem < 1 || problem > 5){
                        throw new Exception();
                    }
                }
                catch (Exception e){
                    problem = 5;
                }

                clients.add(new Client(name, problem));
            }
        }

        for(Client cl:clients){
            cl.start();
        }
    }
}