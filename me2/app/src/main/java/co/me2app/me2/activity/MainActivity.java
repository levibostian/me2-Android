package co.me2app.me2.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import co.me2app.me2.R;
import co.me2app.me2.adapter.ViewPagerNavigationAdapter;

public class MainActivity extends ActionBarActivity {

    private ViewPager mViewPager;
    private ViewPagerNavigationAdapter mNavigationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        setupViewPagerNavigation();
    }

    private void setupViews() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mNavigationAdapter = new ViewPagerNavigationAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mNavigationAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void setupViewPagerNavigation() {
        ActionBar actionBar = getSupportActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
                switchToSelectedTab(tab, fragmentTransaction);
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
                unselectTab(tab, fragmentTransaction);
            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            }
        };

        actionBar.addTab(actionBar.newTab().setText(getString(R.string.tab_1_name)).setTabListener(tabListener)); // TODO tab names are not final. They *need* to change
        actionBar.addTab(actionBar.newTab().setText(getString(R.string.tab_2_name)).setTabListener(tabListener)); // TODO tab names are not final. They *need* to change
        actionBar.addTab(actionBar.newTab().setText(getString(R.string.tab_3_name)).setTabListener(tabListener)); // TODO tab names are not final. They *need* to change
    }

    private void switchToSelectedTab(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    private void unselectTab(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }
}
