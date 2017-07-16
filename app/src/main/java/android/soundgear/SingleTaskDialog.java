package android.soundgear;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Asus on 14.07.2017.
 */

public class SingleTaskDialog extends DialogFragment {

    boolean isStartTimeSet = false;
    boolean isEndTimeSet = false;
    Button mSetStartTimeBtn, mSetEndTimeBtn, mCancelBtn, mOkBtn;

    public SingleTaskDialog(){}

    public static SingleTaskDialog newInstance() {
        return new SingleTaskDialog();
    }

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState ) {

        View view= inflater.inflate(R.layout.dialog_singletask, container);
        mSetStartTimeBtn = (Button) view.findViewById(R.id.button_dialog_setstarttime);
        mSetEndTimeBtn = (Button) view.findViewById(R.id.button_dialog_setendtime);
        mCancelBtn = (Button) view.findViewById(R.id.button_dialog_cancel);
        mOkBtn = (Button) view.findViewById(R.id.button_dialog_ok);

        mSetStartTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        int [] time = {selectedHour, selectedMinute};
                        callOnFinishDialog(Constants.START_TIME, time);
                        mSetStartTimeBtn.setText(selectedHour + ":" + selectedMinute);
                        isStartTimeSet = true;
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Select start time");
                mTimePicker.show();
            }
        });
        mSetEndTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        int [] time = {selectedHour, selectedMinute};
                        callOnFinishDialog(Constants.END_TIME, time);
                        mSetEndTimeBtn.setText(selectedHour + ":" + selectedMinute);
                        isEndTimeSet = true;
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Select end time");
                mTimePicker.show();
            }
        });
        mCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        mOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isStartTimeSet && isEndTimeSet) {
                    callOnFinishDialog(Constants.CLOSE_DIALOG, null);
                    dismiss();
                }
                else {
                    if (!isStartTimeSet) makeToast("Set start time");
                    if (!isEndTimeSet) makeToast("Set end time");
                }
            }
        });

        return view;
    }

    private void callOnFinishDialog(int state, Object data) {
        ((ISingleTaskDialogListener)getTargetFragment()).OnFinishDialog(state, data);
    }

    private void makeToast(String msg) {
        Toast.makeText(getTargetFragment().getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
