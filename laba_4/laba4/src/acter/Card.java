package acter;

import abstractCode.absCard;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Card extends absCard {
    public Card() {
    }

    private static int AllId = 0;
    public Card(String pin, double cash) {
        this.setId(++AllId);
        this.setCash(cash);
        this.setPinCod(pin);
    }
}
