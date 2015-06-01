package lbs.ntq.connector;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import lbs.ntq.BaseActivity;
import lbs.ntq.connector.listbutton.Button;
import lbs.ntq.connector.listbutton.ButtonStatus;
import lbs.ntq.connector.listbutton.ListButtonAdapter;

public class MainActivity extends BaseActivity {
    private ListButtonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        GridView listButton = (GridView) findViewById(R.id.list_button);

        if (adapter == null) {
            adapter = new ListButtonAdapter(this);
            List<Button> buttonList = new ArrayList<Button>();
            Button button = new Button("R370");
            button.setStatus(ButtonStatus.STOP);
            buttonList.add(button);

            button = new Button("MH456");
            button.setStatus(ButtonStatus.PREPARE);
            buttonList.add(button);

            button = new Button("MU796");
            button.setStatus(ButtonStatus.PLAY);
            buttonList.add(button);

            button = new Button("UV136");
            button.setStatus(ButtonStatus.LOCK);
            buttonList.add(button);
            adapter.setListButton(buttonList);
        }

        listButton.setAdapter(adapter);
    }
}