package android.soundgear.schedules;

import java.sql.Time;

/**
 * Created by Asus on 14.07.2017.
 */

public class SingleTask {

    private Time mStartTime;
    private Time mEndTime;

    public SingleTask () {}

    public Time getmStartTime() {
        return mStartTime;
    }

    public void setmStartTime(Time mStartTime) {
        this.mStartTime = mStartTime;
    }

    public Time getmEndTime() {
        return mEndTime;
    }

    public void setmEndTime(Time mEndTime) {
        this.mEndTime = mEndTime;
    }
}
