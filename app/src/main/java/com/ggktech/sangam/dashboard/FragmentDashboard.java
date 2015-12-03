package com.ggktech.sangam.dashboard;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ggktech.sangam.R;
import com.ggktech.sangam.leave.ActivityAddLeave;
import com.ggktech.sangam.timesheet.ActivityTimeSheet;


public class FragmentDashboard extends Fragment implements View.OnClickListener {
    private Button buttonTimeSheet;
    private Button buttonLeaves;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        buttonTimeSheet = (Button) view.findViewById(R.id.buttonTimeSheet);
        buttonLeaves = (Button) view.findViewById(R.id.buttonLeaves);

        buttonTimeSheet.setOnClickListener(this);
        buttonLeaves.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonTimeSheet) {
            Intent intent = new Intent(getActivity(), ActivityTimeSheet.class);
            startActivity(intent);
        } else if (view.getId() == R.id.buttonLeaves) {
            Intent intent = new Intent(getActivity(), ActivityAddLeave.class);
            startActivity(intent);
        }


    }
}
