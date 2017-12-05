package com.example.cravrr.shareprefrence;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Cravrr on 11/10/2017.
 */

public class PrefActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);
    }



}
