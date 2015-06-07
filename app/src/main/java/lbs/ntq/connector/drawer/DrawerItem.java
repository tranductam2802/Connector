package lbs.ntq.connector.drawer;

import java.util.List;

import lbs.ntq.connector.listbutton.Button;

/**
 * Created by PhuongQuynh on 02/06/2015.
 */
public class DrawerItem {
    private String id;
    private String timestamp = "11:33AM";
    private List<Button> buttonList;
    private String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<Button> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<Button> buttonList) {
        this.buttonList = buttonList;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}