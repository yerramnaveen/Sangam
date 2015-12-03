package com.ggktech.sangam.timesheet;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ggktech.sangam.R;
import com.ggktech.sangam.addtask.ActivityAddNewTask;
import com.ggktech.sangam.addtask.ActivityPendingTimeSheet;
import com.ggktech.sangam.leave.ActivityAddLeave;
import com.ggktech.sangam.utilites.DatePickerFragment;
import com.ggktech.sangam.utilites.Utilites;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentTimeSheet extends Fragment implements View.OnClickListener,DatePickerDialog.OnDateSetListener{

    private Button buttonTodaysTimeSheet;
    private Button buttonPendingTimeSheet;
    private Button buttonAddNewTask;
    private TextView textViewDate;
    private TextView textViewApplyLeave;
    private ListView listViewTasks;
    private LinearLayout linearLayoutTaskHeaders;
    private EditText editTextHoursWorked;

    ArrayList<ListviewContactItem> contactlist = new ArrayList<ListviewContactItem>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time_sheet,container,false);
        buttonTodaysTimeSheet = (Button)view.findViewById(R.id.buttonTodaysTimeSheet);
        buttonPendingTimeSheet = (Button)view.findViewById(R.id.buttonPendingTimeSheet);
        buttonAddNewTask =(Button)view.findViewById(R.id.buttonAddNewTask);
        textViewDate = (TextView)view.findViewById(R.id.textViewDate);
        textViewApplyLeave =(TextView)view.findViewById(R.id.textViewApplyLeave);
        listViewTasks = (ListView)view.findViewById(R.id.listViewTasks);
        editTextHoursWorked = (EditText)view.findViewById(R.id.editTextHoursWorked);
        linearLayoutTaskHeaders = (LinearLayout)view.findViewById(R.id.linearLayoutTaskHeaders);
        buttonTodaysTimeSheet.setBackgroundColor(Utilites.getColor(getActivity(), R.color.common_signin_btn_default_background));
        buttonTodaysTimeSheet.setOnClickListener(this);
        buttonPendingTimeSheet.setOnClickListener(this);
        buttonAddNewTask.setOnClickListener(this);
        textViewDate.setOnClickListener(this);
        textViewApplyLeave.setOnClickListener(this);
        linearLayoutTaskHeaders.setOnClickListener(this);
        // Set default date to date dateTextView
        textViewDate.setText(Utilites.defaultDate());
        defaultTimeHoursWorked();
        Utilites.startTime = "Start Time";

        Utilites.hours =Utilites.currentHour();
        Utilites.minutes = Utilites.currentMinute();


        return view;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        textViewDate.setText(String.valueOf(dayOfMonth) + "-" + String.valueOf(monthOfYear + 1)
                + "-" + String.valueOf(year));
    }


    private void defaultTimeHoursWorked(){
        Utilites.startTaskTotalWord = Calendar.getInstance();
        Utilites.endTaskTotalWord = Calendar.getInstance();

    }
//    private  ArrayList<ListviewContactItem> GetlistContact(){
//
//
//
//        return contactlist;
//
//    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.buttonAddNewTask:
                Intent intent = new Intent(getActivity(),ActivityAddNewTask.class);
                startActivityForResult(intent, 1);

                break;
            case R.id.buttonPendingTimeSheet:
                intent = new Intent(getActivity(),ActivityPendingTimeSheet.class);
                startActivity(intent);
                break;
            case R.id.textViewDate:
                selectDate();
                break;
            case R.id.textViewApplyLeave:
                intent = new Intent(getActivity(),ActivityAddLeave.class);
                startActivity(intent);
                break;

        }

    }

    private void selectDate(){
        DatePickerFragment date = new DatePickerFragment();
        date.setCallBack(this);
        date.show(getFragmentManager(), "Date Picker");
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        editTextHoursWorked.setText(Utilites.msToString(Utilites.endTaskTotalWord.getTimeInMillis()-Utilites.startTaskTotalWord.getTimeInMillis()));
        if(resultCode==Activity.RESULT_OK){
            ListviewContactItem   listviewContactItem = new ListviewContactItem();
            listviewContactItem.taskLocation=data.getStringExtra("difference");
            listviewContactItem.taskType = data.getStringExtra("spinnerProject");

            contactlist.add(listviewContactItem);

            if(contactlist.size()>0){
                linearLayoutTaskHeaders.setVisibility(View.VISIBLE);
            }

            setListViewHeightBasedOnChildren(listViewTasks);
            ListViewTaskAdapter adapter = new ListViewTaskAdapter(getActivity(), contactlist);
            adapter.notifyDataSetChanged();
            listViewTasks.setAdapter(adapter);
            Toast.makeText(getActivity(),"on Activity"+data.getStringExtra("spinnerLocation"),Toast.LENGTH_SHORT).show();
        }
    }


    private  void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
