package com.example.prajwal.suck.Adapter;



/**
 * Created by prajwal on 2/9/17.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prajwal.suck.*;
import com.example.prajwal.suck.Network.VolleySingleton;
import com.example.prajwal.suck.R;
import com.example.prajwal.suck.pojo.ongoingContest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prajwal on 2/9/17.
 */

public class AdapterListContest extends RecyclerView.Adapter<AdapterListContest.ViewHolderListContest> {

private ArrayList<ongoingContest> listContest=new ArrayList<>();
    private LayoutInflater layoutInflater;
    private VolleySingleton volleySingleton;



    public AdapterListContest(Context context){

        layoutInflater=LayoutInflater.from(context);
        volleySingleton = VolleySingleton.getInstance();


    }

    public void setLiveContestList(ArrayList<ongoingContest> listContest){
        this.listContest=listContest;
        notifyItemRangeChanged(0,listContest.size());
    }

    @Override
    public ViewHolderListContest onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.custom_live_contest_list,parent,false);
        ViewHolderListContest viewHolder=new ViewHolderListContest(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolderListContest holder, int position) {

        ongoingContest currentContest=listContest.get(position);
        holder.mPlatform.setText(currentContest.getPlatform());
        holder.mName.setText(currentContest.getName());
        holder.mEndTime.setText(currentContest.getEndTime());
        holder.mUrl.setText(currentContest.getUrl());



    }

    @Override
    public int getItemCount() {
        return listContest.size();
    }

    static class ViewHolderListContest extends RecyclerView.ViewHolder{

        private TextView mPlatform;
        private TextView mName;
        private TextView mEndTime;
        private TextView mUrl;


        public ViewHolderListContest(View itemView){
            super(itemView);
            mPlatform=itemView.findViewById(R.id.Platformname);
            mName=itemView.findViewById(R.id.contestTitle);
            mEndTime=itemView.findViewById(R.id.timeofcontest);
            mUrl=itemView.findViewById(R.id.url);
        }
    }




}


