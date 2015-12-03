package com.ggktech.sangam.addtask;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import com.ggktech.sangam.R;
import com.ggktech.sangam.timesheet.ActivityTimeSheet;
import com.ggktech.sangam.utilites.Utilites;
import java.util.ArrayList;


public class FragmentPendingTimeSheet extends Fragment implements View.OnClickListener {

    Button buttonPendingTimeSheet,buttonTodaysTimeSheet;
    ListView listViewPending;
    ArrayList<ListviewContactItemPendind> contactlist = new ArrayList<ListviewContactItemPendind>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pending_time_sheet, container, false);
        buttonPendingTimeSheet = (Button) view.findViewById(R.id.buttonPendingTimeSheet);
        buttonTodaysTimeSheet = (Button) view.findViewById(R.id.buttonTodaysTimeSheet);
        listViewPending = (ListView)view.findViewById(R.id.listViewPending);
        buttonPendingTimeSheet.setBackgroundColor(Utilites.getColor(getActivity(), R.color.common_signin_btn_default_background));
        buttonTodaysTimeSheet.setOnClickListener(this);
        addData();
        ListViewPendingTimeAdapter adapter = new ListViewPendingTimeAdapter(getActivity(), contactlist);
        adapter.notifyDataSetChanged();
        listViewPending.setAdapter(adapter);
        return view;
    }

    private void addData(){
        for (int i = 1; i <10; i++) {
            ListviewContactItemPendind listviewContactItemPendind = new ListviewContactItemPendind();
            listviewContactItemPendind.date= "10-1"+i+"-2015";
            listviewContactItemPendind.status="Not Started";
            contactlist.add(listviewContactItemPendind);
            
        }
    }



    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonTodaysTimeSheet:
                Intent intent = new Intent(getActivity(), ActivityTimeSheet.class);
                startActivity(intent);

                break;
        }
    }

}
