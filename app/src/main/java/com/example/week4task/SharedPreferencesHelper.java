package com.example.week4task;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {

    public static final String RADIO_BTN_CHOICE = "RADIO_BTN_CHOICE";

    private SharedPreferences mSharedPreferences;

    public SharedPreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(RADIO_BTN_CHOICE, Context.MODE_PRIVATE);
    }

    public void setRadioBtnData(String string) {
        mSharedPreferences.edit().putString(RADIO_BTN_CHOICE, string).apply();
    }

    public String getRadioBtnData() {
        return mSharedPreferences.getString(RADIO_BTN_CHOICE, RADIO_BTN_CHOICE);
    }
}
