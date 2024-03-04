package information.Card;
import abstraktCode.UserInfo.*;
import information.Schet.Schet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardInfo extends  AbstractUserInfo{
    private static int AllID = 0;

    private int thisId;
    private String pinCod;
    private int SchetId;
    private boolean activate;

    private static final String[] viewName = {"Credit", "Current"};
    public static String[] getViewName() {
        return viewName;
    }

    public CardInfo(int userID) {
        System.out.println("CREATE NEW CARD");
        this.setThisId();
        this.setOwnerId(userID);
        this.setView(GetView());
        this.setPinCod();
        this.activate = true;
    }

    public CardInfo(int userID, viewEnum view) {
        System.out.println("CREATE NEW CARD");
        this.setThisId();
        this.setOwnerId(userID);
        this.setView(view);
        this.setPinCod();
        this.activate = true;
    }

    public int getThisId() {
        return thisId;
    }
    public void setThisId() {
        this.thisId = ++AllID;
    }

    public void ShowInfo(){
        System.out.println("User ID = "+this.getOwnerId());
        System.out.println("Card ID = "+this.getThisId());
        System.out.println("View card = "+this.getView());
        System.out.println("Pincod = "+this.getPinCod());
        System.out.println("Activity = "+this.isActivate());
    }


    public String getPinCod() {
        return pinCod;
    }
    public void setPinCod() {
        String pinCod;

        while (true)
        {
            System.out.print("Enter 4 numbers for PinCod:\t");
            pinCod = new Scanner(System.in).next();
            Matcher match = Pattern.compile("^[0-9]{4}$").matcher(pinCod);

            try{
                if(match.matches())
                {
//                    System.out.println("All Correct");
                    this.pinCod = pinCod;
                    break;
                }
                throw new Exception("Uncorrect pincod");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    public int getSchetId() {
        return SchetId;
    }
    public void setSchetId(int schetId) {
        SchetId = schetId;
    }

    private viewEnum GetView(){
        System.out.println("Enter which card you need(defoult \"Credit\"):");
        int view;
        for (int i =0 ; i<CardInfo.getViewName().length;i++)
        {
            System.out.println(i+1+")"+CardInfo.getViewName()[i]);
        }
        view = new Scanner(System.in).nextInt();

        if(view<=1||view>viewName.length)
            return viewEnum.Credit;
        return viewEnum.Current;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }
    public String isActivate() {
        return activate?"Activate":"Not activate";
    }
    public boolean checkActivate(){return activate;}
}
