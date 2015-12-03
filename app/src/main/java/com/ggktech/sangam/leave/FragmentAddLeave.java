package com.ggktech.sangam.leave;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ggktech.sangam.R;

public class FragmentAddLeave extends Fragment implements View.OnClickListener {

    Button buttonLeaveDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_leave, container, false);
        buttonLeaveDetails = (Button) view.findViewById(R.id.buttonLeaveDetails);
        buttonLeaveDetails.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonLeaveDetails) {
            Intent intent = new Intent(getActivity(), ActivityLeaveDetails.class);
            startActivity(intent);

        }
    }
}
