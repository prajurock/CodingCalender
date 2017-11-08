package com.example.prajwal.suck.JSON;

import org.json.JSONObject;

/**
 * Created by prajwal on 26/9/17.
 */

public class Utils {

    public static boolean contains(JSONObject jsonobject, String key) {
        return jsonobject!=null && jsonobject.has(key) && !jsonobject.isNull(key) ?true:false;
    }
}
