package com.ggktech.sangam.leave;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ggktech.sangam.R;

public class ActivityLeaveDetails extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_details);
        FragmentLeaveDetails fragmentLeaveDetails = (FragmentLeaveDetails)getFragmentManager().findFragmentById(R.layout.fragment_leave_details);
    }


}
