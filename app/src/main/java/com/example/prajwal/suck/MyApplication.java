package com.example.prajwal.suck;

import android.app.Application;
import android.content.Context;

import com.example.prajwal.coder.Databases.ContestDatabases;

/**
 * Created by prajwal on 30/8/17.
 */

public class MyApplication extends Application {

    private static MyApplication sInstance;

    private static ContestDatabases mDatabase;



    public static Context getAppContext(){
        return sInstance.getApplicationContext();
    }

    public synchronized static ContestDatabases getWritableDatabase(){
        if (mDatabase==null){
            mDatabase=new ContestDatabases(getAppContext());
        }
        return mDatabase;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;
        mDatabase=new ContestDatabases(this);
    }

    public static MyApplication getsInstance(){
        return sInstance;
    }

}
