package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        /* get sandwich info from json constants */
        final String GET_NAME = "name";
        final String SW_NAME = "mainName";
        final String SW_ORIGIN = "placeOfOrigin";
        final String SW_DESCRIPTION = "description";
        final String SW_IMG = "image";
        final String SW_KNOWN_AS = "alsoKnownAs";
        final String SW_INGREDIENT = "ingredients";

        /* declarations variables for a Sandwich */
        String sandwichName, placeOfOrigin, description;
        List<String> alsoKnownAs = new ArrayList<>(), ingredients = new ArrayList<>();
        String imageLink;

        try {
            JSONObject sandwichJSON = new JSONObject(json);
            /* (error check 1) check error here? */

            JSONObject name = sandwichJSON.getJSONObject(GET_NAME);
            sandwichName = name.getString(SW_NAME);
            JSONArray knownAsArray = name.getJSONArray(SW_KNOWN_AS);
            if (knownAsArray.length() == 0)
                alsoKnownAs.add("N/A");
            else
                alsoKnownAs.add(knownAsArray.getString(0));

            placeOfOrigin = sandwichJSON.getString(SW_ORIGIN);
            description = sandwichJSON.getString(SW_DESCRIPTION);
            imageLink = sandwichJSON.getString(SW_IMG);
            JSONArray ingredientsJSONArr = sandwichJSON.getJSONArray(SW_INGREDIENT);
            for (int i = 0; i < ingredientsJSONArr.length(); i++) {
                ingredients.add(ingredientsJSONArr.getString(i));
            }
//            Log.v("TAG", sandwichName);
//            Log.v("TAG", placeOfOrigin);
//            Log.v("TAG", description);
//            Log.v("TAG", imageLink);
//            Log.v("TAG", ingredients.toString());
//            Log.v("TAG", alsoKnownAs.toString());
            return new Sandwich(sandwichName, alsoKnownAs, placeOfOrigin, description, imageLink, ingredients);
        } catch (JSONException e) {
            Log.v("JSON", "invalid JSON data");
            return null;
        }
    }
}
