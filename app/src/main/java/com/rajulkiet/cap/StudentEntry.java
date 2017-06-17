package com.rajulkiet.cap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class StudentEntry extends AppCompatActivity {
    public EditText Name, Email, Branch, Contact, Section, Rollno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_entry);
        Button Sub = (Button) findViewById(R.id.submit);
        Name = (EditText) findViewById(R.id.name);
        Email = (EditText) findViewById(R.id.email);
        Branch = (EditText) findViewById(R.id.branch);
        Contact = (EditText) findViewById(R.id.contact);
        Section = (EditText) findViewById(R.id.section);
        Rollno = (EditText) findViewById(R.id.rollno);
    }
    public void SubmitData(View v){
        ParseObject obj = new ParseObject("students");
        ParseACL acl = new ParseACL();
        acl.setPublicReadAccess(true);
        obj.setACL(acl);
        obj.put("student_id", Rollno.getText().toString());
        obj.put("name", Name.getText().toString());
        obj.put("branch", Branch.getText().toString());
        obj.put("section", Section.getText().toString());
        obj.put("email", Email.getText().toString());
        obj.put("contact", Contact.getText().toString());
        obj.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(getApplicationContext(), "yo", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
