package com.example.ryan.cbushackapp2018;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ReportScreen extends AppCompatActivity
{
    public Context context;
    private ArrayList<Report> reports;
    private DBHelper db = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_screen);

        reports = db.getAllReports();

        ListAdapter adapter = new ListAdapter(this, reports);
        ListView listView = (ListView) findViewById(R.id.reportList);
        listView.setAdapter(adapter);
    }
}
