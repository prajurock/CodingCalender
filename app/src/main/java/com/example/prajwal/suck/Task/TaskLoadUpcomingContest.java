package com.example.prajwal.suck.Task;

import android.graphics.Movie;
import android.os.AsyncTask;

import com.android.volley.RequestQueue;
import com.example.prajwal.suck.CallBacks.UpcomingContestLoadedListner;
import com.example.prajwal.suck.Network.VolleySingleton;
import com.example.prajwal.suck.extras.pastUtils;
import com.example.prajwal.suck.fragments.FragmentPast;
import com.example.prajwal.suck.pojo.ongoingContest;

import java.util.ArrayList;

/**
 * Created by prajwal on 25/9/17.
 */

public class TaskLoadUpcomingContest extends AsyncTask<Void,Void,ArrayList<ongoingContest>> {
    private UpcomingContestLoadedListner myComponent;
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;


    public TaskLoadUpcomingContest(UpcomingContestLoadedListner myComponent)
    {
        this.myComponent=myComponent;
        volleySingleton=VolleySingleton.getInstance();
        requestQueue=volleySingleton.getRequestQueue();
    }




    @Override
    protected ArrayList<ongoingContest> doInBackground(Void... params)
    {
        ArrayList<ongoingContest> listContest= pastUtils.loadUpcomingContest(requestQueue);
        return listContest;
    }


    @Override
    protected void onPostExecute(ArrayList<ongoingContest> listContest)
    {
        if (myComponent != null) {
            myComponent.onUpcomingContestLoadedListner(listContest);
        }
    }
}
