package object;

import java.util.Scanner;

public class Parking {
    private int placeSize = 5;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parking(int id) {
        this.id = id;
        this.setPlaceSize();
    }

    public int getPlaceSize() {
        return placeSize;
    }

    public void setPlaceSize() {
        int helpValue;

        try {
            helpValue = new Scanner(System.in).nextInt();

            if(helpValue < 1 || helpValue > 10)
                return;
        }
        catch (Exception e){
            return;
        }

        this.placeSize = helpValue;
    }
}
