package com.example.prajwal.suck.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.prajwal.suck.Adapter.AdapterListContest;
import com.example.prajwal.suck.CallBacks.UpcomingContestLoadedListner;
import com.example.prajwal.suck.MyApplication;
import com.example.prajwal.suck.Network.VolleySingleton;
import com.example.prajwal.suck.R;
import com.example.prajwal.suck.Task.TaskLoadUpcomingContest;
import com.example.prajwal.suck.extras.Constants;
import com.example.prajwal.suck.logging.L;
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
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentPast#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPast extends Fragment implements UpcomingContestLoadedListner {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String KEY_CONTEST ="Key Contest" ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<ongoingContest> listContest=new ArrayList<>();
    private AdapterListContest adapterListContest;
    private RecyclerView listLiveContesthits;
    private TextView textViewVolleyerror;


        public FragmentPast() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPast.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPast newInstance(String param1, String param2) {
        FragmentPast fragment = new FragmentPast();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(KEY_CONTEST,listContest);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_past, container, false);
        textViewVolleyerror=view.findViewById(R.id.textVolleyError);
        listLiveContesthits=view.findViewById(R.id.listContest);
        listLiveContesthits.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterListContest=new AdapterListContest(getActivity());
        if (savedInstanceState!=null){
            listContest=savedInstanceState.getParcelableArrayList(KEY_CONTEST);
        }
        else {
           listContest= MyApplication.getWritableDatabase().getAllContestList();
            if (listContest.isEmpty()){
                L.t(getActivity(),"Executing From Fragment");
                new TaskLoadUpcomingContest(this).execute();
            }
        }
        adapterListContest.setLiveContestList(listContest);

        return view;

    }



    private void handleVolleyError(VolleyError error){

        if(error instanceof TimeoutError || error instanceof NoConnectionError){
            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
            builder.setMessage("NO INTERNET ACCESS")
                    .setIcon(android.R.drawable.ic_menu_slideshow)
                    .show();


        }
        else if (error instanceof AuthFailureError){

        }
        else if (error instanceof ServerError){

        }
        else if (error instanceof NetworkError){

        }
        else if (error instanceof ParseError){

        }



    }


    @Override
    public void onUpcomingContestLoadedListner(ArrayList<ongoingContest> listContest) {
        L.t(getActivity(),"oUpcomingContestLoaded Fragmnet");
        adapterListContest.setLiveContestList(listContest);
    }
}
