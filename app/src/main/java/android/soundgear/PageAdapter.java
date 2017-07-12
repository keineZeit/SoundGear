package android.soundgear;

/**
 * Created by Asus on 12.07.2017.
 */

import android.content.Context;
import android.soundgear.fragments.AirplaneFragment;
import android.soundgear.fragments.SoundFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class PageAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    private String tabtitles[] = new String[] { "Tab1", "Tab2" };
    public PageAdapter(FragmentManager mgr) {
        super(mgr);
    }

    @Override
    public int getCount() {
        return(PAGE_COUNT);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0: return SoundFragment.newInstance("SoundFragment");
            case 1: return AirplaneFragment.newInstance("IN WORK");
            default: return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}