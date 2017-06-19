package com.rajulkiet.cap;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class AttendanceUpdate extends AppCompatActivity {
    //Creating a list of Students
    private ArrayList<Students> students;
    //Creating Views
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false);
        students = new ArrayList<>();
        //Method to get Data
        getData();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Log.i("as", "see");

        //a
        // dapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    public void getData() {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("students");
        query.addAscendingOrder("student_id");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    if (objects.size() > 0)
                        parseData(objects);
                }
            }
        });

    }

    private void parseData(List<ParseObject> obj) {
        for (ParseObject stu : obj) {
            Log.i("out", stu.get("student_id").toString());
            Students studInfo = new Students();
            try {
                studInfo.setRollno(stu.getString("student_id"));
            } catch (Exception e) {
                Log.i("not", "raeas");
                e.printStackTrace();
            }
            students.add(studInfo);
        }
        adapter = new AttendanceUpdateAdapter(students, getApplicationContext());
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
