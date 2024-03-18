package abstractCode;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public abstract class absCard {
    private int id;
    private  double cash;
    private String pinCod;

    public String getPinCod() {
        return pinCod;
    }
    public void setPinCod(String pinCod) {
        this.pinCod = pinCod;
    }
    public double getCash() {
        return cash;
    }
    public void setCash(double cash) {
        this.cash = cash;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
