package com.ggktech.sangam.addtask;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ggktech.sangam.R;

public class ActivityAddNewTask extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);
        FragmentAddNewTask fragmentAddNewTask = (FragmentAddNewTask)getFragmentManager().findFragmentById(R.layout.fragment_add_new_task);
    }


}
