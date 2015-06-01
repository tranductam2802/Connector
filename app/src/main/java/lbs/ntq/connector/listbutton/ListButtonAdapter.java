package lbs.ntq.connector.listbutton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lbs.ntq.connector.R;

/**
 * Created by PhuongQuynh on 31/05/2015.
 */
public class ListButtonAdapter extends BaseAdapter {
    private Context context;
    private List<Button> listButton;

    public ListButtonAdapter(Context context) {
        this.context = context;
        listButton = new ArrayList<Button>();
    }

    @Override
    public int getCount() {
        return listButton.size();
    }

    @Override
    public Button getItem(int position) {
        return listButton.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_list_button, parent, false);
            holder = new ViewHolder();
            holder.txtTime = (TextView) convertView.findViewById(R.id.time);
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.vBorder = convertView.findViewById(R.id.button_border);
            holder.imgButton = (ImageView) convertView.findViewById(R.id.button);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // TODO:
        Button button = getItem(position);

        // Set button name
        String name = button.getName();
        holder.txtName.setText(name);

        int status = button.getStatus();
        switch (status) {
            case ButtonStatus.STOP:
                holder.imgButton.setBackgroundResource(R.drawable.button_stop_shape);
                break;
            case ButtonStatus.PREPARE:
                holder.imgButton.setBackgroundResource(R.drawable.button_prepare_shape);
                break;
            case ButtonStatus.PLAY:
                holder.imgButton.setBackgroundResource(R.drawable.button_play_shape);
                break;
            case ButtonStatus.LOCK:
                holder.imgButton.setBackgroundResource(R.drawable.button_lock_shape);
                break;
        }

        return convertView;
    }

    public class ViewHolder {
        public TextView txtName;
        public TextView txtTime;
        public View vBorder;
        public ImageView imgButton;
    }

    public void setListButton(List<Button> listButton) {
        if (listButton != null) {
            this.listButton = listButton;
        }
    }
}