package com.example.prajwal.suck.JSON;

import com.example.prajwal.suck.extras.Constants;
import com.example.prajwal.suck.pojo.ongoingContest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.prajwal.suck.extras.Keys.EndPointBoxOffice.KEY_ENDTIME;
import static com.example.prajwal.suck.extras.Keys.EndPointBoxOffice.KEY_NAME;
import static com.example.prajwal.suck.extras.Keys.EndPointBoxOffice.KEY_ONGOING;
import static com.example.prajwal.suck.extras.Keys.EndPointBoxOffice.KEY_PLATFORM;
import static com.example.prajwal.suck.extras.Keys.EndPointBoxOffice.KEY_RESULT;
import static com.example.prajwal.suck.extras.Keys.EndPointBoxOffice.KEY_URL;

/**
 * Created by prajwal on 26/9/17.
 */

public class Parsor {

    public static ArrayList<ongoingContest> parseJSONResponse(JSONObject response){
        ArrayList<ongoingContest> listContest = new ArrayList<>();
        if (response==null||response.length()==0) {}

        else{




            try {

                JSONObject objectOngoing = response.getJSONObject(KEY_RESULT);
                JSONArray arrayOngoing = objectOngoing.getJSONArray(KEY_ONGOING);
                for (int i = 0; i < arrayOngoing.length(); i++) {
                    JSONObject currentContest = arrayOngoing.getJSONObject(i);

                    String Name= Constants.NA;
                    String title=Constants.NA;
                    String endTime=Constants.NA;

                    String url=Constants.NA;

                    if(Utils.contains(currentContest,KEY_NAME))

                        Name = currentContest.getString(KEY_NAME);
                    if(Utils.contains(currentContest,KEY_PLATFORM))

                        title = currentContest.getString(KEY_PLATFORM);
                    if(Utils.contains(currentContest,KEY_ENDTIME))

                        endTime = currentContest.getString(KEY_ENDTIME);
                    if(Utils.contains(currentContest,KEY_URL))

                        url = currentContest.getString(KEY_URL);


                    ongoingContest ongoingcontest = new ongoingContest(Name, title, url, endTime);//Use the constructor to fill the data
                    ongoingcontest.setPlatform(title);
                    ongoingcontest.setName(Name);
                    ongoingcontest.setEndTime(endTime);
                    ongoingcontest.setUrl(url);
                    if(!title.equals(Constants.NA))
                        listContest.add(ongoingcontest);
                }
            } catch (JSONException e) {


            }
            //    L.t(getActivity(),listContest.size()+"rows fetched");
        }


        return listContest;
    }


}

