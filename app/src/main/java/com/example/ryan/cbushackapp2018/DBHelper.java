package com.example.ryan.cbushackapp2018;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;

public class DBHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Database.db";
    private static final String TABLE_NAME = "REPORTS";
    private static final String COLUMN_NAME_ID = "ID";
    private static final String COLUMN_NAME_SUBMITTER = "Submitter";
    private static final String COLUMN_NAME_VICTIM = "Victim";
    private static final String COLUMN_NAME_BULLY = "Bully";
    private static final String COLUMN_NAME_DATE_AND_TIME = "DateAndTime";
    private static final String COLUMN_NAME_LOCATION = "Location";
    private static final String COLUMN_NAME_DESCRIPTION = "Description";
    private static final String[] COLUMNS_ALL = {
            COLUMN_NAME_ID,
            COLUMN_NAME_SUBMITTER,
            COLUMN_NAME_VICTIM,
            COLUMN_NAME_BULLY,
            COLUMN_NAME_DATE_AND_TIME,
            COLUMN_NAME_LOCATION,
            COLUMN_NAME_DESCRIPTION
    };

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SQL_QUERY_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME_SUBMITTER + " TEXT," +
                    COLUMN_NAME_VICTIM + " TEXT," +
                    COLUMN_NAME_BULLY + " TEXT," +
                    COLUMN_NAME_DATE_AND_TIME + " INTEGER," +
                    COLUMN_NAME_LOCATION + " TEXT," +
                    COLUMN_NAME_DESCRIPTION + " TEXT)";



    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void addReport(Report report)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_SUBMITTER, report.getSubmitter());
        values.put(COLUMN_NAME_VICTIM, report.getVictim());
        values.put(COLUMN_NAME_BULLY, report.getBully());
        values.put(COLUMN_NAME_DATE_AND_TIME, report.getDateAndTime().getTime());
        values.put(COLUMN_NAME_LOCATION, report.getLocation());
        values.put(COLUMN_NAME_DESCRIPTION, report.getDescription());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<Report> getAllReports()
    {
        ArrayList<Report> reportList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SQL_QUERY_SELECT_ALL, null);

        if (cursor.moveToFirst())
        {
            do
            {
                Report report = new Report();
                report.setId(Integer.parseInt(cursor.getString(0)));
                report.setSubmitter(cursor.getString(1));
                report.setVictim(cursor.getString(2));
                report.setBully(cursor.getString(3));
                report.setDateAndTime(new Date(Long.parseLong(cursor.getString(4))));
                report.setLocation(cursor.getString(5));
                report.setDescription(cursor.getString(6));

                reportList.add(report);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return reportList;
    }

    public Report getReport(int id)
    {
        String[] selectionArgument = new String[] { String.valueOf(id) };
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(
                TABLE_NAME,
                COLUMNS_ALL,
                COLUMN_NAME_ID + "=?",
                selectionArgument,
                null,
                null,
                null,
                null
        );

        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        Report report = new Report();
        report.setId(Integer.parseInt(cursor.getString(0)));
        report.setSubmitter(cursor.getString(1));
        report.setVictim(cursor.getString(2));
        report.setBully(cursor.getString(3));
        report.setDateAndTime(new Date(Long.parseLong(cursor.getString(4))));
        report.setLocation(cursor.getString(5));
        report.setDescription(cursor.getString(6));

        cursor.close();
        db.close();
        return report;
    }
}
