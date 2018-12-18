package com.sherry.myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        pager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabs = findViewById(R.id.tabs);
        tabs.setViewPager(pager);

    }
    /** 创建菜单 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /** 设置菜单的点击事件 */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                //Intent i = new Intent(this, SettingsActivity.class);
                //startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /** fragment的适配器 */
    public class MyAdapter extends FragmentPagerAdapter {

        //fragment的标题
        private String[] titles = { "录音", "列表" };

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return RecordFragment.newInstance(position);

                case 1:
                    return RecordFragment.newInstance(position);

            }
            return null;
        }

        @Override
        public int getCount() {
            return titles.length;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
