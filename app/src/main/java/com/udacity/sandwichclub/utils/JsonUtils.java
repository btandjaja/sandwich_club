package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        /* Sandwich info. Each sandwich's info in an element of the "list" array */
        final String SWM_LIST = "list";

        /* Message code */
        final String SWM_MESSAGE_CODE = "cod";

        /* String array to hold each day's weather String */
        String[] parseSandwichData = null;

        JSONObject sandwichJSON = new JSONObject(json);

        /* check for error object */
        if(sandwichJSON.has(SWM_MESSAGE_CODE)){
            int errorCode = sandwichJSON.getInt(SWM_MESSAGE_CODE);
            switch (errorCode) {
                case HttpURLConnection.HTTP_OK:
                    break;
                case HttpURLConnection.HTTP_NOT_FOUND:
                    /* invalid location */
                    return null;
                default:
                    /* server down */
                    return null;
            }
        }

        JSONArray sandwichArray = sandwichJSON.getJSONArray(SWM_LIST);

        parseSandwichData = new String[sandwichArray.length()];

        return null;
    }
}
