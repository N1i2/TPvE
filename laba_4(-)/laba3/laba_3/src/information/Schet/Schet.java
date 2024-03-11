package information.Schet;
import abstraktCode.UserInfo.*;
import information.Card.CardInfo;

import java.util.Scanner;

public class Schet extends  AbstractUserInfo{
    static private int AllID = 0;
    private double cashAccount = 0;

    public Schet(CardInfo card) {
        System.out.println("CREATE NEW SCHET");
        this.setThisId(++AllID);
        this.setOwnerId(card.getThisId());
        this.setView(card.getView());
        this.setCashAccount();
    }

    public double getCashAccount() {
        return cashAccount;
    }
    public void setCashAccount() {
        System.out.print("Enter how much mony you give:");
        addCashAccount(new Scanner(System.in).nextDouble());
    }
    public void addCashAccount(double cashAccount) {
        if(this.getView() == viewEnum.Current && -cashAccount > this.cashAccount) {
            System.out.println("A non-credit card cannot have credit");
            return;
        }
        this.cashAccount += cashAccount;
    }

    public void ShowInformation(){
        System.out.println("Schet ID = "+this.getThisId());
        System.out.println("Card ID = "+this.getOwnerId());
        System.out.println("Schet view = "+this.getView().toString());
        System.out.println("Mony = "+this.getCashAccount());
    }

    public void ShowSchet(){
        System.out.println(this.getCashAccount());
    }
}