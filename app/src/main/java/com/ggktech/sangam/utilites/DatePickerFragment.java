package com.ggktech.sangam.utilites;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;


import java.util.Calendar;

//reference : http://stackoverflow.com/questions/20673609/implement-a-datepicker-inside-a-fragment
/**
 * Created by Yerram Naveen Kumar on 22-11-2015.
 */
public class DatePickerFragment extends DialogFragment  {

    DatePickerDialog.OnDateSetListener onDateSet;

//    public DatePickerFragment() {}

    public void setCallBack(DatePickerDialog.OnDateSetListener onDateSet) {
        this.onDateSet = onDateSet;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Using current date as default date
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),onDateSet, year, month, day);
    }

}
