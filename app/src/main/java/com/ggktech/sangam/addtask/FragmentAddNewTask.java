package com.ggktech.sangam.addtask;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.ggktech.sangam.R;
import com.ggktech.sangam.utilites.TimePickerFragment;
import com.ggktech.sangam.utilites.Utilites;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;


public class FragmentAddNewTask extends Fragment implements  View.OnClickListener,TimePickerDialog.OnTimeSetListener{


    private Button buttonSave;
    private TextView textViewStartTime;
    private TextView textViewEndTime;
    private Spinner spinnerProject,spinnerTask,spinnerLocation;

    int count = 1;
    boolean startTime = false;
    boolean endTime = false;

    long difference;

    Calendar startTimeCalendar = Calendar.getInstance();
    Calendar endTimeCalendar= Calendar.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_new_task,container,false);
        buttonSave = (Button)view.findViewById(R.id.buttonSave);
        textViewStartTime = (TextView)view.findViewById(R.id.textViewStartTime);
        textViewEndTime = (TextView)view.findViewById(R.id.textViewEndTime);
        spinnerProject = (Spinner)view.findViewById(R.id.spinnerProject);
        spinnerTask = (Spinner)view.findViewById(R.id.spinnerTask);
        spinnerLocation = (Spinner)view.findViewById(R.id.spinnerLocation);


        textViewEndTime.setOnClickListener(this);
        buttonSave.setOnClickListener(this);
        if( Utilites.startTime.equalsIgnoreCase("Start Time")){
         startTimeCalendar = Calendar.getInstance();
           endTimeCalendar= Calendar.getInstance();
            textViewStartTime.setOnClickListener(this);
        }else{
            textViewStartTime.setText(Utilites.startTime);

            endTimeCalendar.set(Calendar.HOUR, Utilites.hours);

            startTimeCalendar.set(Calendar.HOUR, Utilites.minutes);


            Log.v("TAG", startTimeCalendar.getTimeInMillis() + " START TIME");
//            Log.v("TAG", Utilites.endTimeCalendar.getTimeInMillis()+"ET");

        }

//        hours =Utilites.currentHour();
//        minutes = Utilites.currentMinute();
        return view;
    }
private void backButton(){


    Toast.makeText(getActivity(), "Task added successfully", Toast.LENGTH_SHORT).show();
    Intent returnIntent = new Intent();
    returnIntent.putExtra("spinnerProject", spinnerProject.getSelectedItem().toString());
    returnIntent.putExtra("spinnerTask", spinnerTask.getSelectedItem().toString());
    returnIntent.putExtra("spinnerLocation", spinnerLocation.getSelectedItem().toString());
    returnIntent.putExtra("startTime", textViewStartTime.getText().toString());
    returnIntent.putExtra("endTime", textViewEndTime.getText().toString());
    returnIntent.putExtra("comments", "comments");
    returnIntent.putExtra("difference",Utilites.msToString(difference));
    getActivity().setResult(Activity.RESULT_OK, returnIntent);
    getActivity().finish();
}

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonSave:
                backButton();

                break;
            case R.id.textViewStartTime:
                startTime = true;
                endTime = false;
                selectTime(Utilites.hours,Utilites.minutes);
                break;
            case R.id.textViewEndTime:
                endTime = true;
                startTime= false;
                selectTime(Utilites.hours,Utilites.minutes);
                break;
        }
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        int initHour,initMinute;
        initHour = hourOfDay;
        initMinute = minute;
        Utilites.hours = hourOfDay;
        Utilites.minutes = minute;
        String minuteAppend;
       String format;
        if (hourOfDay == 0) {
            hourOfDay += 12;
            format = "AM";
        }
        else if (hourOfDay == 12) {
            format = "PM";
        } else if (hourOfDay > 12) {
            hourOfDay -= 12;
            format = "PM";
        } else {
            format = "AM";
        }
        if(minute<=9){
            minuteAppend = "0"+minute;
        }else{
            minuteAppend = minute+"";
        }

     if(startTime){
         textViewStartTime.setText(new StringBuilder().append(hourOfDay).append(" : ").append(minuteAppend).append(" ").append(format));
//         Utilites.startTimeCalendar.set(Calendar.HOUR, initHour);
//         Utilites.startTimeCalendar.set(Calendar.MINUTE,initMinute);
     }else {
        endTimeCalendar.set(Calendar.HOUR, initHour);
        endTimeCalendar.set(Calendar.MINUTE, initMinute);
         timeValidation();
         textViewEndTime.setText(new StringBuilder().append(hourOfDay).append(" : ").append(minuteAppend).append(" ").append(format));
         Utilites.startTime=textViewEndTime.getText().toString().trim();

         if(count==1) {
             count+=1;

             Log.v("TAG", "STR diff: " +startTimeCalendar.getTimeInMillis());
                          Log.v("TAG", "END Time: " + endTimeCalendar.getTimeInMillis());
             difference = endTimeCalendar.getTimeInMillis() - startTimeCalendar.getTimeInMillis();
             Log.v("TAG", "diff: " + difference);
             Log.v("TAG", "Count ");
         }

     }
    }
    private void timeValidation(){
    if(endTimeCalendar.compareTo(startTimeCalendar)<=0){
        Toast.makeText(getActivity(),"End time is lesser than start time"+endTimeCalendar.compareTo(startTimeCalendar),Toast.LENGTH_SHORT).show();
    }
   }

    private void selectTime(int hours,int minutes){
        TimePickerFragment timePickerFragment = new TimePickerFragment();
        Bundle args = new Bundle();
        args.putInt("hour",hours);
        args.putInt("minute", minutes);
        timePickerFragment.setArguments(args);

        timePickerFragment.setCallBack(this);
        timePickerFragment.show(getFragmentManager(), "Date Picker");
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent returnIntent = new Intent();
            getActivity().setResult(Activity.RESULT_CANCELED, returnIntent);
            getActivity().finish();
            return true;
        }
        return getActivity().onKeyDown(keyCode, event);
    }
}
