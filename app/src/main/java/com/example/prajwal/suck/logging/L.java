package com.example.prajwal.suck.logging;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by prajwal on 30/8/17.
 */

public class L {

    public static void m(String message){
        Log.d("Prajwal",""+message);}

    public static void t(Context context,String message){
        Toast.makeText(context,message+" ",Toast.LENGTH_SHORT).show();
    }
    public static void T(Context context,String message){
        Toast.makeText(context,message+" ",Toast.LENGTH_LONG).show();
    }
}
