package com.ggktech.sangam.addtask;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ggktech.sangam.R;
import com.ggktech.sangam.timesheet.ListviewContactItem;

import java.util.ArrayList;

/**
 * Created by naveen.yerram on 11/25/2015.
 */
public class ListViewPendingTimeAdapter extends BaseAdapter {


    private static ArrayList<ListviewContactItemPendind> listContact;

    private LayoutInflater mInflater;
    public ListViewPendingTimeAdapter(Context addNewTaskFragment, ArrayList<ListviewContactItemPendind> results){
        listContact = results;
        Log.v("TAG", "Size:" + listContact.size());
        mInflater = LayoutInflater.from(addNewTaskFragment);
    }

    @Override
    public int getCount() {
        return listContact.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.content_item_pendind_timesheet, null);
            holder = new ViewHolder();
            holder.textViewDate = (TextView) convertView.findViewById(R.id.textViewDate);
            holder.texViewStatus = (TextView) convertView.findViewById(R.id.texViewStatus);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textViewDate.setText(listContact.get(position).date);
        holder.texViewStatus.setText(listContact.get(position).status);



        return convertView;
    }

    static class ViewHolder{
        TextView textViewDate, texViewStatus;
    }




}
