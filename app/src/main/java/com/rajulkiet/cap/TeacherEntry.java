package com.rajulkiet.cap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

public class TeacherEntry extends AppCompatActivity {

    Spinner sp1;
    EditText con, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_entry);

        sp1 = (Spinner) findViewById(R.id.spinner);
       /* sp = (Spinner) findViewById(R.id.spinner2);
        sp1.setOnItemSelectedListener(this);
*/
        con = (EditText) findViewById(R.id.contact);
        email = (EditText) findViewById(R.id.email);

    }


    /*  @Override
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
  */
    public void TeacherSubmit(View view) {
        final String emailis = email.getText().toString();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("TEACHERS");
        query.whereEqualTo("id", emailis.split("@")[0].toString());
        final ParseObject[] obje = new ParseObject[1];
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                for (ParseObject obj : objects) {
                    if (e == null)
                        obje[0] = obj;
                    else
                        obje[0] = new ParseObject("TEACHERS");

                }
                ParseACL acl = new ParseACL();
                acl.setPublicReadAccess(true);
                obje[0].setACL(acl);
                obje[0].put("branch", sp1.getSelectedItem().toString());
                obje[0].put("contact", con.getText().toString());
                obje[0].put("email", emailis);
                obje[0].put("id", emailis.split("@")[0].toString());

                obje[0].saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }
  /*  @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/


}
