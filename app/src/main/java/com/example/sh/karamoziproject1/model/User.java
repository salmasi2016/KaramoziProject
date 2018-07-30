package com.example.sh.karamoziproject1.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String strFirstName, strLastName, strEmail;

    protected User(Parcel in) {
        strFirstName = in.readString();
        strLastName = in.readString();
        strEmail = in.readString();
    }

    public User() {
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getStrFirstName() {
        return strFirstName;
    }

    public void setStrFirstName(String strFirstName) {
        this.strFirstName = strFirstName;
    }

    public String getStrLastName() {
        return strLastName;
    }

    public void setStrLastName(String strLastName) {
        this.strLastName = strLastName;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(strFirstName);
        dest.writeString(strLastName);
        dest.writeString(strEmail);
    }
}