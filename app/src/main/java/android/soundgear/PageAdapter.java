package android.soundgear;

/**
 * Created by Asus on 12.07.2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    public PageAdapter(FragmentManager mgr) {
        super(mgr);
    }
    @Override
    public int getCount() {
        return(2);
    }
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0: return SoundFragment.newInstance("SoundFragment, Instance 1");
            case 1: return AirplaneFragment.newInstance("AirplaneFragment, Instance 1");
            default: return null;
        }
    }
}