package acterFile.User;
import abstraktCode.Possibilites.IUserPossibilities;
import information.Card.CardInfo;
import information.Schet.Schet;

import java.util.ArrayList;
import java.util.Scanner;

public class User implements IUserPossibilities {
    static int AllID = 0;
    public User(String name) {
        System.out.println("CREAT NEW USER");
        this.setId();
        this.setName(name);
        this.setPassword();
        this.uCard.add(new CardInfo(this.getId()));
        this.uSchet.add(new Schet(uCard.get(0)));
        this.uCard.get(0).setSchetId(this.uSchet.get(0).getThisId());
    }

    @Override
    public void BlockedCard(String index, ArrayList<User> users){
        if(!this.getuCard().get(Integer.parseInt(index)).checkActivate()){
            System.out.print("Sorry but this card already blocked");
            return;
        }
        String pinCod;

        System.out.print("Enter pinCod if you wont to block this card: ");
        pinCod = new Scanner(System.in).next();

        if(!this.getuCard().get(Integer.parseInt(index)).getPinCod().equals(pinCod)){
            System.out.print("Uncorrect pincod");
            return;
        }

        this.getuCard().get(Integer.parseInt(index)).setActivate(false);
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String password;
    public boolean CheckPassword(String check){
        return password.equals(check);
    }
    private String getPassword() {
        return password;
    }
    public void setPassword() {
        String password;
        while (true)
        {
            System.out.print("Enter your password:\t");
            password = new Scanner(System.in).next();

            try{
                if(password.length() >= 5 && password.length() <= 10)
                {
                    //System.out.println("All Correct");
                    this.password = password;
                    break;
                }
                throw new Exception("Password size from 5 to 10 characters");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }

    private int id;
    public int getId() {
        return id;
    }
    public void setId() {
        this.id = ++AllID;
    }

    private ArrayList<CardInfo> uCard = new ArrayList<CardInfo>();
    public ArrayList<CardInfo> getuCard() {
        return uCard;
    }
    public void setuCard() {
        String whereSchet;

        System.out.println("1) Link to old schet");
        System.out.println("Any other number) Create a new schet");
        System.out.print("Enter you chois: ");
        whereSchet = new Scanner(System.in).next();

        if(whereSchet.equals("1")){

            int index = 0;

            System.out.println("Select an account");
            for(int i = 0;i< this.getuSchet().size();i++){
                System.out.println(i+1+") Schet ID = " + this.getuSchet().get(i).getThisId());
            }

            System.out.print("Choose a card: ");
            index = new Scanner(System.in).nextInt();

            if(index < 1 || index > this.getuSchet().size())
                index = 0;
            else
                index--;

            uCard.add(new CardInfo(this.getId(), this.getuSchet().get(index).getView()));

            this.uCard.getLast().setSchetId(this.uSchet.get(index).getThisId());
        }
        else{
            uCard.add(new CardInfo(this.getId()));
            this.uSchet.add(new Schet(uCard.getLast()));
            this.uCard.getLast().setSchetId(this.uSchet.getLast().getThisId());
        }
    }

    private ArrayList<Schet> uSchet = new ArrayList<Schet>();
    public ArrayList<Schet> getuSchet() {
        return uSchet;
    }

    public void ShowInfo(){
        System.out.println("USER");
        System.out.println("Name = " + getName());
        System.out.println("Password = " + getPassword());
        System.out.println("Id = "+getId());
        System.out.println("CARD");
        this.uCard.get(0).ShowInfo();
        System.out.println("SCHET");
        this.uSchet.get(0).ShowInformation();
    }
}
