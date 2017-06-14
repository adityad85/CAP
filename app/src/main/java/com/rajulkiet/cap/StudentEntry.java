package com.rajulkiet.cap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentEntry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_entry);
        Button sub= (Button) findViewById(R.id.submit);
        EditText name=(EditText)findViewById(R.id.name);
        EditText email=(EditText)findViewById(R.id.email);
        EditText branch=(EditText)findViewById(R.id.branch);
        EditText contact=(EditText)findViewById(R.id.contact);
        EditText section=(EditText)findViewById(R.id.section);
    }
    public void SubmitData(View v){


    }
}
