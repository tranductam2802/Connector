package lbs.ntq.connector.listbutton;

/**
 * Created by PhuongQuynh on 31/05/2015.
 */
public class Button {
    private String id = "";
    private String name = "";
    private String timestamp = ButtonStatus.NON_TASK_MSG;
    private int status = ButtonStatus.STOP;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Button(String name) {
        this.name = name;
        this.timestamp = timestamp;
        this.status = status;
    }
}