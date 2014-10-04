package co.me2app.me2.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import co.me2app.me2.fragment.GetHelpFragment;
import co.me2app.me2.fragment.SendHelpFragment;
import co.me2app.me2.fragment.SupportFragment;

public class ViewPagerNavigationAdapter extends FragmentPagerAdapter {

    private static final int NUM_CHILDREN = 3;

    private static final int GET_HELP_INDEX = 0;
    private static final int SEND_HELP_INDEX = 1;
    private static final int SUPPORT_INDEX = 2;

    public ViewPagerNavigationAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case GET_HELP_INDEX:
                return GetHelpFragment.newInstance();
            case SEND_HELP_INDEX:
                return SendHelpFragment.newInstance();
            case SUPPORT_INDEX:
                return SupportFragment.newInstance();
        }

        throw new IllegalStateException("There is something wrong with the number of items in the viewpager navigation");
    }

    @Override
    public int getCount() {
        return NUM_CHILDREN;
    }
}
