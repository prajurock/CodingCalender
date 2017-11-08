package com.example.prajwal.suck.pojo;


import android.os.Parcel;
import android.os.Parcelable;

import com.example.prajwal.suck.logging.L;

/**
 * Created by prajwal on 31/8/17.
 */

public class ongoingContest implements Parcelable {

    public String Name;
    public String Platform;
    public String url;
    public String EndTime;

    public ongoingContest(){

    }

    public ongoingContest(String Name,
                          String Platform,
                          String url,
                          String EndTime){
        this.Name=Name;
        this.Platform=Platform;
        this.url=url;
        this.EndTime=EndTime;
    }

    protected ongoingContest(Parcel in) {
        Name = in.readString();
        Platform = in.readString();
        url = in.readString();
        EndTime = in.readString();
    }

    public static final Parcelable.Creator<ongoingContest> CREATOR = new Creator<ongoingContest>() {
        @Override
        public ongoingContest createFromParcel(Parcel in) {
            L.m("create from parceable: OnfoingContest");
            return new ongoingContest(in);
        }

        @Override
        public ongoingContest[] newArray(int size) {
            return new ongoingContest[size];
        }
    };

    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public String getPlatform(){
        return Platform;
    }
    public void setPlatform(String Platform){
        this.Platform=Platform;
    }
    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url=url;
    }
    public String getEndTime(){
        return EndTime;
    }
    public void setEndTime(String EndTime){
        this.EndTime=EndTime;
    }

    @Override
    public String toString() {
        return Platform+"\n"
                ;
    }

    @Override
    public int describeContents() {
        L.m("Describe Contest Movie");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        L.m("Write to parceable");
        parcel.writeString(Name);
        parcel.writeString(Platform);
        parcel.writeString(url);
        parcel.writeString(EndTime);




    }
}
