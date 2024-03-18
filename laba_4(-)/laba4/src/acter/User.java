package acter;

import abstractCode.UserDo;
import acter.Card;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.*;
import java.util.stream.Collectors;

@JsonAutoDetect
public class User implements UserDo {
    public User() {
    }

    public User(String name, String password) {
        this.setName(name);
        this.setPassword(password);
    }

    private String Name;
    private String Password;
    private ArrayList<Card> cards  = new ArrayList<Card>();

    public ArrayList<Card> getCards() {
        return cards;
    }
    public void setCards(String pin, double cash) {
        this.cards.add(new Card(pin, cash));
    }

    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public void ShowMyCard(){
        int i = 0;

        List<Card> myCards = cards.stream()
                .sorted(Comparator.comparingDouble(Card::getCash))
                .collect(Collectors.toList());

        for(; i < myCards.size(); i++){
            System.out.println(i+1+" cards");
            System.out.println("id = " + myCards.get(i).getId());
            System.out.println("cash = " + myCards.get(i).getCash());
            System.out.println("pincod = " + myCards.get(i).getPinCod());
        }
        if(i == 0)
            System.out.println("You dont have cards");
    }
    public void ShowMyInfo(){
        System.out.println("Name = " + getName());
        System.out.println("Password = " + getPassword());
        ShowMyCard();
    }
}
