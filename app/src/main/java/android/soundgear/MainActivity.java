package android.soundgear;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.gigamole.navigationtabstrip.NavigationTabStrip;

public class MainActivity extends AppCompatActivity {

    int SOUND_FRAG = 0;
    int AIRPLANE_FRAG = 1;
    private NavigationTabStrip mNavigationTabStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new PageAdapter(getSupportFragmentManager()));
        mNavigationTabStrip = (NavigationTabStrip) findViewById(R.id.nts_title);
        mNavigationTabStrip.setViewPager(mViewPager, SOUND_FRAG);
        mNavigationTabStrip.setTitles("Sound", "Airplane");
    }

    private void setUI() {
//        final NavigationTabStrip navigationTabStrip = (NavigationTabStrip) findViewById(R.id.nts);
//        navigationTabStrip.setTitles("Nav", "Tab", "Strip");
//        navigationTabStrip.setTabIndex(0, true);
//        navigationTabStrip.setTitleSize(15);
//        navigationTabStrip.setStripColor(Color.RED);
//        navigationTabStrip.setStripWeight(6);
//        navigationTabStrip.setStripFactor(2);
//        navigationTabStrip.setStripType(NavigationTabStrip.StripType.LINE);
//        navigationTabStrip.setStripGravity(NavigationTabStrip.StripGravity.BOTTOM);
//        navigationTabStrip.setTypeface("fonts/typeface.ttf");
//        navigationTabStrip.setCornersRadius(3);
//        navigationTabStrip.setAnimationDuration(300);
//        navigationTabStrip.setInactiveColor(Color.GRAY);
//        navigationTabStrip.setActiveColor(Color.WHITE);
//        navigationTabStrip.setOnPageChangeListener(...);
//        navigationTabStrip.setOnTabStripSelectedIndexListener(...);
    }
}
