package com.rajulkiet.cap;

import android.content.Intent;
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
import com.parse.GetCallback;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

public class TeacherEntry extends AppCompatActivity {

    Spinner sp1;
    EditText con, email, firstName, lastName;

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
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);

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
        query.getFirstInBackground(new GetCallback<ParseObject>() {
                                       @Override
                                       public void done(ParseObject object, ParseException e) {
                                           ParseObject oo = object;
                                           if (oo == null) {
                                               oo = new ParseObject("TEACHERS");
                                           }
                                           ParseACL acl = new ParseACL();
                                           acl.setPublicReadAccess(true);
                                           String br = sp1.getSelectedItem().toString();
                                           oo.setACL(acl);
                                           Log.i("herere", br);
                                           oo.put("branch", br);
                                           oo.put("contact", con.getText().toString());
                                           oo.put("email", emailis);
                                           oo.put("id", emailis.split("@")[0].toString());
                                           oo.put("first", firstName.getText().toString());
                                           oo.put("last", lastName.getText().toString());

                                           oo.saveInBackground(new SaveCallback() {
                                               @Override
                                               public void done(ParseException e) {
                                                   if (e != null)
                                                       Log.i("eee", e.getMessage().toString());
                                                   else {
                                                       Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
                                                       Intent i = new Intent(getApplicationContext(), AttendanceUpdate.class);
                                                       startActivity(i);
                                                   }
                                               }
                                           });
                                       }
                                   }
        );



    }
  /*  @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/


}
