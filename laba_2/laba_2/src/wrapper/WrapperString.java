package wrapper;

import java.util.Objects;
/** Задание h*/
/**
 *
 * @author Nikolay
 * @version 0.3
 *
 * */
public class WrapperString {
    private String PrivateStr;

    public WrapperString(String privateStr) {
        PrivateStr = privateStr;
    }
    public void setPrivateStr(String privateStr) {
        PrivateStr = privateStr;
    }

    public String getPrivateStr() {
        return PrivateStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(PrivateStr, that.PrivateStr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PrivateStr);
    }

    @Override
    public String toString() {
        return "WrapperString{" +
                "PrivateStr='" + PrivateStr + '\'' +
                '}';
    }

    public void replac(char oldchar, char newchar) {
        char[] text = PrivateStr.toCharArray();

        for (int i = 0; i < text.length; i++) {
            if (text[i] == oldchar) {
                text[i] = newchar;
            }
        }

        PrivateStr = new String(text);
    }
}