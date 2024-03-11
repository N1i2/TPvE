package abstraktCode.UserInfo;

public abstract class AbstractUserInfo {
    private int ownerId;
    public int getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    private int thisId;
    public int getThisId() {
        return thisId;
    }
    public void setThisId(int thisId) {
        this.thisId = thisId;
    }

    public enum viewEnum{
        Credit,
        Current
    }

    private viewEnum view;
    public viewEnum getView() {
        return view;
    }
    public void setView(viewEnum view) {
        this.view = view;
    }
}
