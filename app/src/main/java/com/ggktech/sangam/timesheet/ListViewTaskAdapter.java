package com.ggktech.sangam.timesheet;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ggktech.sangam.R;

import java.util.ArrayList;

/**
 * Created by naveen.yerram on 11/24/2015.
 */
public class ListViewTaskAdapter extends BaseAdapter {
    private static ArrayList<ListviewContactItem> listContact;

    private LayoutInflater mInflater;
    public ListViewTaskAdapter(Context addNewTaskFragment, ArrayList<ListviewContactItem> results){
        listContact = results;
        Log.v("TAG","Size:"+listContact.size());
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
            convertView = mInflater.inflate(R.layout.contact_item, null);
            holder = new ViewHolder();
            holder.textViewTaskType = (TextView) convertView.findViewById(R.id.listView__content_item_textViewTaskType);
            holder.textViewTaskDuation = (TextView) convertView.findViewById(R.id.listView__content_item_textViewTaskDuation);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textViewTaskType.setText(listContact.get(position).taskType);
        holder.textViewTaskDuation.setText(listContact.get(position).taskLocation);

        return convertView;
    }

    static class ViewHolder{
        TextView textViewTaskType, textViewTaskDuation;
    }
}
