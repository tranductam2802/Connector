package lbs.ntq.connector.schedule;

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
 * Created by PhuongQuynh on 02/06/2015.
 */
public class ScheduleAdapter extends BaseAdapter {
    private Context context;
    private List<ScheduleItem> itemList;

    public ScheduleAdapter(Context context) {
        this.context = context;
        itemList = new ArrayList<ScheduleItem>();
    }

    public void setItemList(List<ScheduleItem> itemList) {
        if (itemList != null) {
            this.itemList = itemList;
        }
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public ScheduleItem getItem(int position) {
        return itemList.get(position);
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
            convertView = inflater.inflate(R.layout.item_schedule, parent, false);
            holder = new ViewHolder();

            holder.btnStatus = (ImageView) convertView.findViewById(R.id.schedule_status);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position % 3 == 0) {
            holder.btnStatus.setSelected(true);
        } else {
            holder.btnStatus.setSelected(false);
        }

        return convertView;
    }

    public class ViewHolder {
        public TextView txtName;
        public TextView txtTime;
        public ImageView btnStatus;
    }
}
