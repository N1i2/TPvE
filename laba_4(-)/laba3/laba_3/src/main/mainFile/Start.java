package main.mainFile;
import acterFile.Admin.Admin;
import acterFile.User.*;
import information.Schet.Schet;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

class Main{
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml",LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("Start");

        ArrayList<User> users = new ArrayList<User>();
        User MyUser = null;
        String chois;

        while (true) {
            try {
                if(MyUser == null) {
                    System.out.println("1) Creat new user");
                    System.out.println("2) Log in");
                    System.out.println("3) end");
                    System.out.println("Enter Numbber");
                    chois = new Scanner(System.in).next();

                    if (chois.equals("1")) {
                        MyUser = CreatOrTake(Integer.parseInt(chois) - 1, users);
                        if (MyUser != null)
                            users.add(MyUser);
                        MyUser = null;
                        continue;
                    } else if (chois.equals("2")) {
                        MyUser = CreatOrTake(Integer.parseInt(chois) - 1, users);
                    } else if (chois.equals("3")) {
                        break;
                    } else {
                        throw new Exception("You are mistaken");
                    }

                    if (MyUser == null) {
                        throw new Exception("Try again");
                    }
                }

                System.out.println("1) View bank account");
                System.out.println("2) Top up your account");
                System.out.println("3) Add new card");
                System.out.println("4) Block the card");
                System.out.println("Any other number will leave the account");
                System.out.print("Enter Numbber:\t");
                chois = new Scanner(System.in).next();

                if(chois.equals("1")){
                    int index = GetCardIndex(MyUser);
                    GetSchet(MyUser, MyUser.getuCard().get(index).getSchetId()).ShowSchet();
                }
                else if(chois.equals("2")){
                    int index = GetCardIndex(MyUser);
                    if(!MyUser.getuCard().get(index).checkActivate()){
                        throw new Exception("Sorry but this card is blocked");
                    }
                    GetSchet(MyUser, MyUser.getuCard().get(index).getSchetId()).setCashAccount();
                }
                else if(chois.equals("3")){
                    MyUser.setuCard();
                }
                else if(chois.equals("4")){
                    int index = GetCardIndex(MyUser);

                    MyUser.BlockedCard(index+"", null);
                }
                else {
                    MyUser = null;
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("The End");
    }

    public static User CreatOrTake(int whatNeed, ArrayList<User> users){
        String name;

        if(whatNeed == 0){
            System.out.print("Enter your nickname:\t");
            name = new Scanner(System.in).next();

            if(LocateName(users, name) != -1 || name.equals("Admin")){
                System.out.println("Sorry name is already taken");
                return null;
            }

            return new User(name);
        }
        else {
            System.out.print("Enter your nickname:\t");
            name = new Scanner(System.in).next();

            if(name.equals("Admin")){
                Admin admin = new Admin();

                System.out.print("Enter your password:\t");
                   if(admin.getPassword().equals(new Scanner(System.in).next())){
                       admin.WhatAdminCan(users);
                   }
            }

            int index = LocateName(users, name);

            if(index == -1){
                System.out.println("Sorry but there is no such name");
                return null;
            }

            System.out.print("Enter your password:\t");
            if(users.get(index).CheckPassword(new Scanner(System.in).next())){
                return users.get(index);
            }

            System.out.println("This is uncorrect password");
            return null;
        }
    }
    public static int LocateName(ArrayList<User>users, String name){
        for (int i =0;i<users.size();i++){
            if(users.get(i).getName().equals(name)){
                return i;
            }
        }

        return -1;
    }
    public static int GetCardIndex(User MyUser){
        int index = 0;

        for(int i = 0;i< MyUser.getuCard().size();i++){
            if(!MyUser.getuCard().get(i).checkActivate()) {
                System.out.print("(Block)=");
            }
            System.out.println(i + 1 + ") Card ID = " + MyUser.getuCard().get(i).getThisId());
        }

        System.out.print("Select an account: ");
        index = new Scanner(System.in).nextInt();

        if(index < 1 || index > MyUser.getuCard().size())
            index = 0;
        else
            index--;

        return index;
    }
    public static Schet GetSchet(User MyUser, int needId){
        for(int i = 0; i<MyUser.getuSchet().size();i++){
            if(MyUser.getuSchet().get(i).getThisId() == needId){
                return MyUser.getuSchet().get(i);
            }
        }
        return MyUser.getuSchet().get(0);
    }
}