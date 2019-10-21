package np.com.alon.model;

public class ConnectionPort {

    private int id;
    private String portNumber;
    private String byteLimit;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    public String getByteLimit() {
        return byteLimit;
    }

    public void setByteLimit(String byteLimit) {
        this.byteLimit = byteLimit;
    }
}
