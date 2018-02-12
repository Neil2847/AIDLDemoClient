package com.example.neil.aidldemo;

/**
 * Created by neil on 2018/2/12.
 */

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by neil on 2018/2/12.
 */

public class User implements Parcelable {

    private String name;
    private String nickname;
    private String phoneNumber;
    private String address;
    private String mail;

    public User(String username) {
        this.name = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public User() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.nickname);
        dest.writeString(this.phoneNumber);
        dest.writeString(this.address);
        dest.writeString(this.mail);
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.nickname = in.readString();
        this.phoneNumber = in.readString();
        this.address = in.readString();
        this.mail = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
