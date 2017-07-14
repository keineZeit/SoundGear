package android.soundgear.fragments;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.soundgear.ISingleTaskDialogListener;
import android.soundgear.R;
import android.soundgear.SingleTaskDialog;
import android.soundgear.schedules.SingleTask;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class SoundFragment extends Fragment implements ISingleTaskDialogListener {

    Button mSetSingleTaskBtn;
    TextView mTV;
    SingleTask mSingleTask;
    private FragmentActivity myContext;

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
                String curDate = new Date().toString();
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        mTV.setText( selectedHour + ":" + selectedMinute);
                        mSingleTask.setmStartTime(new Time(selectedHour, selectedMinute, 0));
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

//    public void btnShowYesNoDialog(View view) {
//        showYesNoDialog();
//    }
//
//    private void showYesNoDialog() {
//        FragmentManager fragmentManager = myContext.getSupportFragmentManager();
//        SingleTaskDialog yesnoDialog = new SingleTaskDialog();
//        yesnoDialog.setCancelable(false);
//        yesnoDialog.setDialogTitle("Select One");
//        yesnoDialog.show(fragmentManager, "Yes/No Dialog");
//    }
    
    @Override
    public void OnFinishDialog(boolean state) {
        Toast.makeText(getActivity(), "Which Option Selected: " + state, Toast.LENGTH_SHORT).show();
    }
}