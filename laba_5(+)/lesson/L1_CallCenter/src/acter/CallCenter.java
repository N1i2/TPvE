package acter;

import resurs.AllProblems;
import resurs.Color;

import java.util.Random;
import java.util.Scanner;

public class CallCenter {
    public CallCenter() {
        this.setOperatorCount();
    }

    private boolean[] operators;
    private int operatorCount = 5;
    private int clientCount = 0;

    public void setOperatorCount() {
        System.out.print("Enter how many worker we have(from 1 to 10): ");
        int helpValue;

        try{
            helpValue = new Scanner(System.in).nextInt();

            if(helpValue <= 0 || helpValue > 10){
                return;
            }
        }
        catch (Exception e){
            return;
        }

        this.operatorCount = helpValue;

        operators = new boolean[operatorCount];
        for(int i = 0; i < operatorCount; i++){
            operators[i] = false;
        }
    }

    public void CellForHelp(Client cl) {
        long start = System.currentTimeMillis();
        long end = start + 2000;
        int operatorNumb;

        synchronized (this) {
            while(true){
            operatorNumb = GetFreeOperator();

            if (operatorNumb < 0) {
                if (System.currentTimeMillis() > end) {
                    System.out.println(Color.RED + "The client " +
                            Color.ORANGE + cl.getNames() + Color.RED +
                            " hung up" + Color.RESET);

                    if (new Random().nextBoolean()) {
                        return;
                    } else {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    System.out.println(Color.BLUE + "Client " +
                            Color.ORANGE + cl.getNames() + Color.BLUE +
                            " calls back " + Color.RESET);
                }
            }
            else {
                System.out.println("The client " +
                        Color.ORANGE + cl.getNames() + Color.RESET +
                        " is served by an operator number " +
                        Color.ORANGE + (operatorNumb + 1) + Color.RESET);
                break;
            }
            }
        }
            try {
                Thread.sleep((new Random().nextInt(5)+1)*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            String ansver;

            if(cl.getProblem() == 1){
                ansver = "Your name is " + cl.getNames();
            }
            else if(cl.getProblem() == 2){
                ansver = "You can change it";
            }
            else if(cl.getProblem() == 3){
                ansver = "I am operator number " + (operatorNumb + 1);
            }
            else if(cl.getProblem() == 4){
                ansver = "Try rebooting something";
            }
            else{
                ansver = "Hello!!!";
            }

            System.out.println(Color.GREEN + "client = "+
                    Color.ORANGE + cl.getNames() + Color.GREEN+
                    "; queshen = " +
                    Color.ORANGE + AllProblems.problems[cl.getProblem() - 1] + Color.GREEN +
                    ";\nansver = " + ansver + "\ncustomer " +
                Color.ORANGE + cl.getNames() + Color.GREEN +
                " served" + Color.RESET);

        operators[operatorNumb] = false;

        cl.interrupt();
    }

    private int GetFreeOperator(){
        for(int i = 0; i < operatorCount; i++){
            if(!operators[i]){
                operators[i] = true;
                return i;
            }
        }

        return -1;
    }
}
