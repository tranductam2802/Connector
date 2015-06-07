package lbs.ntq.connector;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import lbs.ntq.BaseActivity;
import lbs.ntq.connector.drawer.DrawerAdapter;
import lbs.ntq.connector.listbutton.ListButtonAdapter;
import lbs.ntq.navigation.SlidingTabLayout;

public class MainActivity extends BaseActivity {
    private ListButtonAdapter listButtonAdapter;
    private DrawerAdapter drawerAdapter;

    private SlidingTabLayout mSlidingTabLayout;
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
            return view;
        }

        private View getSchedulingView(ViewGroup container) {
            View view = getLayoutInflater().inflate(R.layout.schedule_item,
                    container, false);
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