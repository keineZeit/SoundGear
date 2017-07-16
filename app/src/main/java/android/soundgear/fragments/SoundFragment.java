package android.soundgear.fragments;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.soundgear.Constants;
import android.soundgear.ISingleTaskDialogListener;
import android.soundgear.R;
import android.soundgear.SingleTaskDialog;
import android.soundgear.TimeReceiver;
import android.soundgear.schedules.SingleTask;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SoundFragment extends Fragment implements ISingleTaskDialogListener {

    Button mSetSingleTaskBtn;
    TextView mTV;
    SingleTask mSingleTask;
    private FragmentActivity mContext;

    public static SoundFragment newInstance(String text) {
        SoundFragment fragment = new SoundFragment();
        Bundle args = new Bundle();
        args.putString("mgs", text);
        fragment.setArguments(args);
        return fragment;
    }

    static String getTitle(Context context, int position) {
        return "Page № " + String.valueOf(position+1);
    }

    @Override
    public void onAttach(Activity activity) {
        mContext =(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sound, container, false);

        mSetSingleTaskBtn = (Button) view.findViewById(R.id.button_setSingleTask);
        mTV = (TextView) view.findViewById(R.id.textBox);
        mTV.setText(getArguments().getString("msg"));
        mSingleTask = new SingleTask();

        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mSetSingleTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSingleTaskDialog();
            }
        });
    }

    public void openSingleTaskDialog() {
        SingleTaskDialog singleTaskDialog = new SingleTaskDialog();
        singleTaskDialog.setCancelable(false);
        singleTaskDialog.setTargetFragment(this, 1);
        singleTaskDialog.show(getFragmentManager(), "SingleTask Dialog");
    }
    
    @Override
    public void OnFinishDialog(int state, Object data) {
        int [] startTime;
        int [] endTime;;
        if (data instanceof int[]) {
            if (state == Constants.START_TIME) {
                startTime = (int[]) data;
            }
            if (state == Constants.END_TIME) {
                endTime = (int[]) data;
            }
        }
        if (data == null && state == Constants.CLOSE_DIALOG) {
            int repeatTime = 10;
            AlarmManager processTimer = (AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(mContext, TimeReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, 0,  intent, PendingIntent.FLAG_UPDATE_CURRENT);
            processTimer.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),repeatTime*1000, pendingIntent);
        }
    }

    private void makeToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}