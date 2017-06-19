package com.rajulkiet.cap;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tapTeacher(View view) {
        Intent i = new Intent(getApplication(), TeacherEntry.class);
        startActivity(i);
    }

    public void tapStudent(View view) {
        Intent i = new Intent(getApplication(), StudentEntry.class);
        PackageManager pack = getPackageManager();
        List as = pack.queryIntentActivities(i, PackageManager.MATCH_DEFAULT_ONLY);
        boolean t = as.size() > 0;
        Log.i("here", String.valueOf(t));
        startActivity(i);
    }
}
