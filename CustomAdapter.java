package com.example.roy.studentportal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<portalsObject> {
    private Context context;
    List<portalsObject> mPortals;

    public CustomAdapter(Context context, List<portalsObject> mPortals) {
        super(context, R.layout.custom_list_row, mPortals);
        this.context = context;
        this.mPortals = mPortals;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_list_row, parent, false);

        TextView portalNameView = rowView.findViewById(R.id.portalNameView);
        TextView portalURLView = rowView.findViewById(R.id.portalURLView);

        portalsObject currentPortal = mPortals.get(position);

        portalNameView.setText(currentPortal.getPortalName());
        portalURLView.setText(currentPortal.getPortalURL());



        return rowView;
    }
}
