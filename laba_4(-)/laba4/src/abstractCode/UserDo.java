package abstractCode;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public interface UserDo {
    public void ShowMyCard();
    public void ShowMyInfo();
}
