package com.rajulkiet.cap;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aditya on 6/14/2017.
 */

public class Students implements Parcelable {
    public String name,branch,section,contact,rollno,year;
    protected Students(){

    }
    protected Students(Parcel in){

        name=in.readString();
        branch=in.readString();
        section=in.readString();
        contact=in.readString();
        rollno=in.readString();
        year=in.readString();
    }
public String getName(){
    return name;
}
public String getBranch(){
    return branch;
}
public String getSection()
{
    return section;
}
public String
    public static final Creator<Students> CREATOR = new Creator<Students>() {
        @Override
        public Students createFromParcel(Parcel in) {
            return new Students(in);
        }

        @Override
        public Students[] newArray(int size) {
            return new Students[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(branch);
        dest.writeString(section);
        dest.writeString(contact);
        dest.writeString(rollno);
        dest.writeString(year);
    }
}
