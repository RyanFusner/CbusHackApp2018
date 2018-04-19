package com.example.ryan.cbushackapp2018;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{

    public Context context;
    private DBHelper db = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createListeners();
    }

    private void createListeners()
    {

        Button goToReportScreenButton = (Button) findViewById(R.id.switchButon);
        goToReportScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ReportScreen.class);
                if (intent.resolveActivity(getPackageManager()) != null)
                {
                    startActivityForResult(intent, 0);
                }
            }
        });

        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText submitter = (EditText) findViewById(R.id.nameBox);
                EditText victim = (EditText) findViewById(R.id.victimBox);
                EditText bully = (EditText) findViewById(R.id.bullyBox);
                DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
                TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
                EditText location = (EditText) findViewById(R.id.locationBox);
                EditText description = (EditText) findViewById(R.id.descBox);

                db.addReport(new Report(submitter.getText().toString(), victim.getText().toString(), bully.getText().toString(), new Date(datePicker.getYear()-1900, datePicker.getMonth(), datePicker.getDayOfMonth(), timePicker.getHour(), timePicker.getMinute()), location.getText().toString(), description.getText().toString()));
                submitter.setText("");
                victim.setText("");
                bully.setText("");
                location.setText("");
                description.setText("");
            }
        });
    }
}


