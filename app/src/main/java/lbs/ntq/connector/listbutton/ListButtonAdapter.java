package lbs.ntq.connector.listbutton;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
            convertView = View.inflate(context, R.layout.item_list_button, parent);
            holder = new ViewHolder();
            holder.txtTime = (TextView) convertView.findViewById(R.id.time);
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // TODO:

        return convertView;
    }

    public class ViewHolder {
        public TextView txtName;
        public TextView txtTime;
    }
}