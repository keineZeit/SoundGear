package android.soundgear.fragments;

import android.content.Context;
import android.soundgear.R;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TextView;

import com.gigamole.navigationtabstrip.NavigationTabStrip;

import java.util.Date;

public class SoundFragment extends Fragment {

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

        Button updateButton = (Button) view.findViewById(R.id.updateButton);
        final TextView updateBox = (TextView) view.findViewById(R.id.textBox);
        updateBox.setText(getArguments().getString("msg"));

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curDate = new Date().toString();
                updateBox.setText(curDate);
            }
        });
        return view;
    }
}