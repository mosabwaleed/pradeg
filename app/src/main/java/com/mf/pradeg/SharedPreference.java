package com.mf.pradeg;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.List;

public class SharedPreference {

    public static final String PREFS_NAME = "GIFT_APP";
    public static final String FAVORITES  = "GIFTS";

    public SharedPreference() {
        super();
    }

    // THIS FOUR METHODS ARE USED FOR MAINTAINING FAVORITES.
    public void saveFavorite(Context context, List<Map<String,String>> like) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(like);
        editor.putString(FAVORITES, jsonFavorites);
        editor.apply();
    }

    public void addFavorite(Context context, Map <String,String> like) {
        List<Map<String,String>> favorites = getFavorites(context);
        if (favorites == null) {
            favorites = new ArrayList<>();
            favorites.add(like);
            saveFavorite(context, favorites);
        }
        else {
            favorites.add(like);
            saveFavorite(context,favorites);
        }
    }

    public void removeFavorite(Context context, int index) {
        List<Map<String,String>> favorites = getFavorites(context);
        if (favorites != null) {
            //favorites = new ArrayList<>();
            favorites.remove(index);
            saveFavorite(context, favorites);
        }
    }

    public void removeFavorite(Context context, String like) {
            List<Map<String,String>> favorites = getFavorites(context);
            if (favorites != null) {
                favorites.remove(like);
                saveFavorite(context, favorites);

            }
    }
    public void removeall(Context context) {
        List<Map<String,String>> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.clear();
            saveFavorite(context, favorites);

        }
    }



    public List<Map<String,String>> getFavorites(Context context) {
        SharedPreferences settings;
        List<Map<String,String>> favorites;
        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            Map<String,String> [] favoriteItems = gson.fromJson(jsonFavorites,
                    Map[].class);
            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<>(favorites);
        } else {
            return new ArrayList<>();
        }
        return (ArrayList<Map<String,String>>) favorites;
    }
}