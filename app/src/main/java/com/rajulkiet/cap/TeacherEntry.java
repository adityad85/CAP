package com.rajulkiet.cap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TeacherEntry extends AppCompatActivity implements android.widget.AdapterView.OnItemSelectedListener {
    String[] sub;
    Spinner sp1, sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_entry);

        sp1 = (Spinner) findViewById(R.id.spinner);
        sp = (Spinner) findViewById(R.id.spinner2);
        sp1.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String s1 = sp1.getSelectedItem().toString();
        Log.i("here", s1);
        ArrayAdapter<String> adapter;
        if (s1.contentEquals("CS")) {
            sub = getResources().getStringArray(R.array.CS);
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sub);
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

            sp.setAdapter(adapter);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
