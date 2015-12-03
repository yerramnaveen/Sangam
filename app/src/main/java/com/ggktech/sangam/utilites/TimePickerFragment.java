package com.ggktech.sangam.utilites;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;

import java.util.Calendar;

/**
 * Created by naveen.yerram on 11/23/2015.
 */
public class TimePickerFragment extends DialogFragment {
    int hour,minute;
    TimePickerDialog.OnTimeSetListener onTimeSetListener;

    public void setCallBack(TimePickerDialog.OnTimeSetListener onTimeSetListener){
      this.onTimeSetListener = onTimeSetListener;
    }


    public void setArguments(Bundle args) {
        super.setArguments(args);
        hour = args.getInt("hour");
        minute = args.getInt("minute");

    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        // Use the current time as the default values for the picker
//        final Calendar c = Calendar.getInstance();
//         hour = c.get(Calendar.HOUR_OF_DAY);
//         minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), onTimeSetListener, hour, minute,DateFormat.is24HourFormat(getActivity()));
    }



}
