package com.rajulkiet.cap;

import android.content.Context;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

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
        }
    }
}
