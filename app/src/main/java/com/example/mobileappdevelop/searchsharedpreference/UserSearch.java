package com.example.mobileappdevelop.searchsharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mobile App Develop on 4/22/2017.
 */

public class UserSearch {


    private static final String PREFERENCE_NAME = "User Search";
    private static final String USER_COUNTRY = "email_address";
    private static final String DEFAULT= "No value found";
    String st;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public UserSearch(Context context) {

        this.context=context;
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }
    public void saveSearch(String country){
        editor.putString(USER_COUNTRY,DEFAULT);

    }
    public String getCountry(){
        return sharedPreferences.getString(USER_COUNTRY,DEFAULT);
    }
    public void clearUser(){
        editor.clear();
        editor.commit();
    }

}
