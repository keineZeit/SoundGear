package android.soundgear;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Asus on 14.07.2017.
 */

public class SingleTaskDialog extends DialogFragment {

    Button mSetBtn, mCancelBtn;
    static String DialogBoxTitle;

    public SingleTaskDialog(){}

    public void setDialogTitle(String title) {
        DialogBoxTitle = title;
    }

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState ) {

        View view= inflater.inflate(R.layout.dialog_singletask, container);
        mSetBtn = (Button) view.findViewById(R.id.button_dialog_set);
        mCancelBtn = (Button) view.findViewById(R.id.button_dialog_cancel);

        mSetBtn.setOnClickListener(btnListener);
        mCancelBtn.setOnClickListener(btnListener);

        getDialog().setTitle(DialogBoxTitle);

        return view;
    }

    private View.OnClickListener btnListener = new View.OnClickListener()
    {
        public void onClick(View v) {
            ISingleTaskDialogListener activity = (ISingleTaskDialogListener) getActivity();
            boolean state = ((Button) v).getText().toString().equals("Yes") ? true : false;
            activity.OnFinishDialog(state);
            dismiss();
        }
    };
}
