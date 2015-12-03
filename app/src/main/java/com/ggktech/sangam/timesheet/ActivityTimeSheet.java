package com.ggktech.sangam.timesheet;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ggktech.sangam.R;
import com.ggktech.sangam.dashboard.FragmentDashboard;

public class ActivityTimeSheet extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_sheet);
        FragmentTimeSheet fragmentTimeSheet = (FragmentTimeSheet) getFragmentManager().findFragmentById(R.layout.fragment_time_sheet);
    }
}