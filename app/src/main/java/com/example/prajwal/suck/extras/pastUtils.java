package com.example.prajwal.suck.extras;

import com.android.volley.RequestQueue;
import com.example.prajwal.coder.Databases.ContestDatabases;
import com.example.prajwal.suck.JSON.Endpoints;
import com.example.prajwal.suck.JSON.Parsor;
import com.example.prajwal.suck.JSON.Requestor;
import com.example.prajwal.suck.MyApplication;
import com.example.prajwal.suck.pojo.ongoingContest;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by prajwal on 25/9/17.
 */

public class pastUtils {

    public static ArrayList<ongoingContest> loadUpcomingContest(RequestQueue requestQueue){
        JSONObject response= Requestor.sendRequestUpcomingContest(requestQueue, Endpoints.getRequestUrl());
        ArrayList<ongoingContest> listContest= Parsor.parseJSONResponse(response);
        MyApplication.getWritableDatabase().insertContestUpcoming(listContest,true);
        return listContest;
    }
}
