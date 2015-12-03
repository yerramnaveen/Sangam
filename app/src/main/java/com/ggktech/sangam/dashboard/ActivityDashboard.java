package com.ggktech.sangam.dashboard;

import android.app.Activity;
import android.os.Bundle;

import com.ggktech.sangam.R;

public class ActivityDashboard extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        FragmentDashboard fragmentDashboard = (FragmentDashboard)getFragmentManager().findFragmentById(R.layout.fragment_dashboard);
    }

}
