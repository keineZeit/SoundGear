package android.soundgear.schedules;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Asus on 14.07.2017.
 */

public class SingleTask {

    private Date mStartTime;
    private Date mEndTime;

    public SingleTask () {}

    public Date getmStartTime() {
        return mStartTime;
    }
    public Date getmEndTime() {
        return mEndTime;
    }

    public void setmStartTime(Date mStartTime) {
        this.mStartTime = mStartTime;
    }
    public void setmEndTime(Date mEndTime) {
        this.mEndTime = mEndTime;
    }
}
