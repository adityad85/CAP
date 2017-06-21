package com.rajulkiet.cap;

import android.content.Context;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

/**
 * Created by Aditya on 6/19/2017.
 */

public class AttendanceUpdateAdapter extends RecyclerView.Adapter<AttendanceUpdateAdapter.ViewHolder> {
    List<Students> students;
    private Context context;

    public AttendanceUpdateAdapter(List<Students> students, Context context) {
        super();
        this.students = students;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.attendance_row_update, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        Log.i("haha", "yeag");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Students students1 = students.get(position);
        holder.textViewRollNo.setText(students1.getRollno());
        holder.toggleButtonAttend.setSelected(students1.getAttendState());
        Log.i("got", "in");
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewRollNo;
        public ToggleButton toggleButtonAttend;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewRollNo = (TextView) itemView.findViewById(R.id.rollno);
            toggleButtonAttend = (ToggleButton) itemView.findViewById(R.id.attend);
            toggleButtonAttend.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    ParseQuery<ParseObject> query = ParseQuery.getQuery("attendance_1");
                    query.whereEqualTo("student_id", textViewRollNo.getText().toString());
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> objects, ParseException e) {

                        }
                    });
                    ParseObject obj = new ParseObject("attendance_1");
                    obj.put("student_id", textViewRollNo.getText().toString());
                    obj.put("present", buttonView.isChecked());
                    obj.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e != null) {
                                Log.i("ee", "dds");
                                e.printStackTrace();
                            }

                        }
                    });
                }
            });
        }
    }
}
