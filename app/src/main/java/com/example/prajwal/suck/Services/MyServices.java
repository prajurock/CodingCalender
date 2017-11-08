package com.example.prajwal.suck.Services;

import android.os.AsyncTask;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.example.prajwal.suck.CallBacks.UpcomingContestLoadedListner;
import com.example.prajwal.suck.Network.VolleySingleton;
import com.example.prajwal.suck.Task.TaskLoadUpcomingContest;
import com.example.prajwal.suck.extras.Constants;
import com.example.prajwal.suck.logging.L;
import com.example.prajwal.suck.pojo.ongoingContest;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;



import static com.example.prajwal.suck.extras.Keys.EndPointBoxOffice.KEY_ENDTIME;
import static com.example.prajwal.suck.extras.Keys.EndPointBoxOffice.KEY_NAME;
import static com.example.prajwal.suck.extras.Keys.EndPointBoxOffice.KEY_ONGOING;
import static com.example.prajwal.suck.extras.Keys.EndPointBoxOffice.KEY_PLATFORM;
import static com.example.prajwal.suck.extras.Keys.EndPointBoxOffice.KEY_RESULT;
import static com.example.prajwal.suck.extras.Keys.EndPointBoxOffice.KEY_URL;
import static com.example.prajwal.suck.extras.UrlEndpoints.URL_PAST_EVENT;

/**
 * Created by prajwal on 11/9/17.
 */

public class MyServices extends JobService implements UpcomingContestLoadedListner {

    private JobParameters jobParameters;

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        L.T(this,"onStARTjOB");
        this.jobParameters=jobParameters;
        new TaskLoadUpcomingContest(this).execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        L.t(this,"onStopJob");
        return false;
    }

    @Override
    public void onUpcomingContestLoadedListner(ArrayList<ongoingContest> listContest) {
        L.t(this, "onBoxOfficeMoviesLoaded");
        jobFinished(jobParameters, false);

    }


}
