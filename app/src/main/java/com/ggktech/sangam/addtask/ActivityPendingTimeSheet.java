package com.ggktech.sangam.addtask;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ggktech.sangam.R;

public class ActivityPendingTimeSheet extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_timesheet);
        FragmentPendingTimeSheet fragmentPendingTimeSheet = (FragmentPendingTimeSheet)getFragmentManager().findFragmentById(R.layout.fragment_pending_time_sheet);
    }


}
