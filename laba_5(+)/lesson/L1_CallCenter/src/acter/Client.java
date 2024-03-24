package acter;

import javax.swing.*;

public class Client extends Thread{
    static CallCenter help = new CallCenter();

    public Client(String name, int problem) {
        this.name = name;
        this.problem = problem;
    }

    private String name;
    public String getNames() {
        return name;
    }

    private int problem;
    public int getProblem() {
        return problem;
    }

    @Override
    public void run() {
        help.CellForHelp(this);
    }
}
