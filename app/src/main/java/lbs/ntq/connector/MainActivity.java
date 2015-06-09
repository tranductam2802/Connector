package lbs.ntq.connector;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import lbs.ntq.BaseActivity;
import lbs.ntq.connector.listbutton.Button;
import lbs.ntq.connector.listbutton.ButtonStatus;
import lbs.ntq.connector.listbutton.ListButtonAdapter;
import lbs.ntq.connector.schedule.ScheduleAdapter;
import lbs.ntq.connector.schedule.ScheduleItem;
import lbs.ntq.navigation.SlidingTabLayout;

public class MainActivity extends BaseActivity {
    private TabPagerAdapter tabPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        if (tabPagerAdapter == null) {
            tabPagerAdapter = new TabPagerAdapter();
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(tabPagerAdapter);

        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        slidingTabLayout.setViewPager(viewPager);
    }

    class TabPagerAdapter extends PagerAdapter {
        public final int VIEW_BELL_LIST = 0;
        public final int VIEW_SCHEDULING = 1;
        public final int VIEW_SETTING = 2;

        private ListButtonAdapter listButtonAdapter;
        private ScheduleAdapter scheduleAdapter;

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case VIEW_BELL_LIST:
                    return "Bell list";
                case VIEW_SCHEDULING:
                    return "Scheduling";
                case VIEW_SETTING:
                    return "Setting";
                default:
                    return "N/A";
            }
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = null;
            switch (position) {
                case VIEW_BELL_LIST:
                    view = getBellListView(container);
                    break;
                case VIEW_SCHEDULING:
                    view = getSchedulingView(container);
                    break;
                case VIEW_SETTING:
                    view = getSettingView(container);
                    break;
            }
            container.addView(view);
            return view;
        }

        private View getBellListView(ViewGroup container) {
            View view = getLayoutInflater().inflate(R.layout.list_button_item,
                    container, false);
            GridView listButton = (GridView) view.findViewById(R.id.list_button);
            if (listButtonAdapter == null) {
                listButtonAdapter = new ListButtonAdapter(MainActivity.this);
                List<Button> buttonList = new ArrayList<>();
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
                listButtonAdapter.setListButton(buttonList);
            }
            listButton.setAdapter(listButtonAdapter);
            return view;
        }

        private View getSchedulingView(ViewGroup container) {
            View view = getLayoutInflater().inflate(R.layout.schedule_item,
                    container, false);
            ListView listSchedule = (ListView) view.findViewById(R.id.list_schedule);
            if (scheduleAdapter == null) {
                scheduleAdapter = new ScheduleAdapter(MainActivity.this);
                List<ScheduleItem> scheduleList = new ArrayList<>();
                ScheduleItem item = new ScheduleItem();
                scheduleList.add(item);
                scheduleList.add(item);
                scheduleList.add(item);
                scheduleList.add(item);
                scheduleList.add(item);
                scheduleList.add(item);
                scheduleList.add(item);
                scheduleAdapter.setItemList(scheduleList);
            }
            listSchedule.setAdapter(scheduleAdapter);
            return view;
        }

        private View getSettingView(ViewGroup container) {
            View view = getLayoutInflater().inflate(R.layout.setting_item,
                    container, false);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}