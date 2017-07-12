package android.soundgear.fragments;

/**
 * Created by Asus on 12.07.2017.
 */

import android.soundgear.R;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

public class AirplaneFragment extends Fragment {

    public static AirplaneFragment newInstance(String text) {
        AirplaneFragment fragment = new AirplaneFragment();
        Bundle args = new Bundle();
        args.putString("mgs", text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_airplane, container, false);

        TextView updateBox = (TextView) view.findViewById(R.id.inWork);
        updateBox.setText(getString(R.string.app_in_work));

        return view;
    }
}