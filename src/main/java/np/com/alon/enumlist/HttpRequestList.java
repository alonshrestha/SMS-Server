package np.com.alon.enumlist;

public enum HttpRequestList {


    ADD("ADD"),
    DELETE("DELETE"),
    UPDATE("UPDATE"),
    ALL("ALL"),
    DIRECT_MESSAGE("DIRECT MESSAGE"),
    MESSAGE_FROM_TEMPLATE("MESSAGE FROM TEMPLATE");

    private String status;

    HttpRequestList(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
