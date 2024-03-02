package acterFile.Admin;

import abstraktCode.Possibilites.IUserPossibilities;
import acterFile.User.*;
import information.Card.CardInfo;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements IUserPossibilities {
    public Admin() {
        this.password = "12345678";
    }

    @Override
    public void BlockedCard(String index, ArrayList<User> users){
        String[] ind = index.split("/");

        users.get(Integer.parseInt(ind[0])).getuCard().get(Integer.parseInt(ind[1])).setActivate(false);
    }

    private String password;
    public String getPassword() {
        return password;
    }

    public void WhatAdminCan(ArrayList<User> users){
        System.out.println("Welcom Admin Let's work");

        while (true){
            String chois;
            String index;

            System.out.println("1) Locate user");
            System.out.println("Any other character) Exit");
            System.out.print("Enter your chois: ");
            chois = new Scanner(System.in).next();

            if(chois.equals("1")){
                System.out.println("1) By User Name");
                System.out.println("2) By User ID");
                System.out.println("3) By Card ID");
                System.out.print("Enter your chois: ");
                chois = new Scanner(System.in).next();

                if(chois.equals("1")){
                    System.out.print("Enter user name: ");
                    chois = new Scanner(System.in).next();
                    index = Locate.ByUserName(users, chois);
                    if(index != null) {
                        System.out.print("Enter 1 if you want to block this card: ");
                        if(new Scanner(System.in).next().equals("1")) {
                            BlockedCard(index, users);
                        }
                    }
            }
                else if(chois.equals("2")){
                    System.out.print("Enter user id: ");
                    chois = new Scanner(System.in).next();
                    index = Locate.ByUserId(users, Integer.parseInt(chois));
                    if(index != null) {
                        System.out.print("Enter 1 if you want to block this card: ");
                        if(new Scanner(System.in).next().equals("1")) {
                            BlockedCard(index, users);
                        }
                    }
                }
                else if(chois.equals("3")){
                    System.out.print("Enter card id: ");
                    chois = new Scanner(System.in).next();
                    index = Locate.ByCardId(users, Integer.parseInt(chois));
                    if(index != null) {
                        System.out.print("Enter 1 if you want to block this card: ");
                        if(new Scanner(System.in).next().equals("1")) {
                            BlockedCard(index, users);
                        }
                    }
                }
                else{
                    System.out.println("I don't know this option");
                }
            }
            else {
                break;
            }
        }

        System.out.println("GoodBy");
    }

    static class Locate{
        public static String ByUserName(ArrayList<User> users, String name){
            int result1 = -1;
            String result2;

            for(int i = 0; i < users.size();i++){
                if(users.get(i).getName().equals(name)){
                    result1 = i;
                    break;
                }
            }

            if(result1 == -1) {
                System.out.println("There is no user with this name");
                return null;
            }

            System.out.println("This user have cards:");
            for(int i = 0; i < users.get(result1).getuCard().size();i++){
                if(!users.get(result1).getuCard().get(i).checkActivate())
                    System.out.print("(block)=");
                System.out.println(i+1+") Card ID = " + users.get(result1).getuCard().get(i).getThisId());
            }
            System.out.print("Enter your chois: ");
            result2 = new Scanner(System.in).next();

            try {
                if(Integer.parseInt(result2)<1||
                        Integer.parseInt(result2)>users.get(result1).getuCard().size()){
                    throw new Exception();
                }
            }
            catch (Exception e){
                System.out.println("there is no such card");
                return null;
            }

            result2 = (Integer.parseInt(result2)-1)+"";

            return result1 + "/" + result2;
        }
        public static String ByUserId(ArrayList<User> users, int id){
            int result1 = -1;
            String result2;

            for(int i = 0; i < users.size();i++){
                if(users.get(i).getId() == id){
                    result1 = i;
                    break;
                }
            }

            if(result1 == -1) {
                System.out.println("There is no user with this id");
                return null;
            }

            System.out.println("This user (name = "+ users.get(result1).getName() +") have cards:");
            for(int i = 0; i < users.get(result1).getuCard().size();i++){
                if(!users.get(result1).getuCard().get(i).checkActivate())
                    System.out.print("(block)=");
                System.out.println(i+1+") Card ID = " + users.get(result1).getuCard().get(i).getThisId());
            }
            System.out.print("Enter your chois: ");
            result2 = new Scanner(System.in).next();

            try {
                if(Integer.parseInt(result2)<1||
                    Integer.parseInt(result2)>users.get(result1).getuCard().size()){
                    throw new Exception();
                }
            }
            catch (Exception e){
                System.out.println("there is no such card");
                return null;
            }

            result2 = (Integer.parseInt(result2)-1)+"";

            return result1 + "/" + result2;
        }
        public static String ByCardId(ArrayList<User> users, int id){
            for(int i =0 ; i<users.size();i++){
                for(int j =0;j<users.get(i).getuCard().size();j++){
                    if(users.get(i).getuCard().get(j).getThisId() == id){
                        System.out.println("User name = "+users.get(i).getName());
                        return i+"/"+j;
                    }
                }
            }

            System.out.println("there is no such card");
            return null;
        }
    }
}
