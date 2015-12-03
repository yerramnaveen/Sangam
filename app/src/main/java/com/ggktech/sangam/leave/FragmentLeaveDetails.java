package com.ggktech.sangam.leave;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ggktech.sangam.R;

public class FragmentLeaveDetails extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

  View view = inflater.inflate(R.layout.fragment_leave_details,container,false);
        return view;
    }
}
