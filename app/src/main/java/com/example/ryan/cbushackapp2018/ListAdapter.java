package com.example.ryan.cbushackapp2018;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class ListAdapter extends ArrayAdapter<Report>
{
    private final Activity context;
    private  final ArrayList<Report> reports;

    public ListAdapter(Activity context, ArrayList<Report> reports)
    {
        super(context, R.layout.activity_report_view, reports);
        this.context = context;
        this.reports = reports;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_report_view, null, true);

        TextView victimLabel = (TextView) rowView.findViewById(R.id.reportVictim);
        TextView bullyLabel = (TextView) rowView.findViewById(R.id.reportBully);
        TextView dateAndTimeLabel = (TextView) rowView.findViewById(R.id.reportDateAndTime);
        TextView locationLabel = (TextView) rowView.findViewById(R.id.reportLocation);
        TextView descriptionLabel = (TextView) rowView.findViewById(R.id.reportDescription);
        TextView submitterLabel = (TextView) rowView.findViewById(R.id.reportSubmitter);

        victimLabel.setText(reports.get(position).getVictim());
        bullyLabel.setText("Bullied by: " + reports.get(position).getBully());
        dateAndTimeLabel.setText("When: " + reports.get(position).getDateAndTime().toGMTString());
        locationLabel.setText("Where: " + reports.get(position).getLocation());
        descriptionLabel.setText("Description: " + reports.get(position).getDescription());
        submitterLabel.setText("Submitted by " + reports.get(position).getSubmitter());

        return rowView;
    }
}
