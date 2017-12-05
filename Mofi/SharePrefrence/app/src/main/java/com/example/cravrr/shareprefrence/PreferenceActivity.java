package com.example.cravrr.shareprefrence;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Cravrr on 11/11/2017.
 */

public class PreferenceActivity extends Activity {


        TextView data;
        Button storeInformation, showInformation;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            data=(TextView)findViewById(R.id.data);
            storeInformation=(Button)findViewById(R.id.StoreInfo);
            showInformation=(Button)findViewById(R.id.ShowInfo);

            View.OnClickListener listener=new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    switch(view.getId()){
                        case R.id.StoreInfo:
                            Intent intent = new Intent(getApplicationContext(),PrefActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.ShowInfo:
                            displaySharePreferenceData();
                            break;
                        default:
                            break;

                    }
                }
            };

            storeInformation.setOnClickListener(listener);
            showInformation.setOnClickListener(listener);

        }

        public void displaySharePreferenceData(){

            SharedPreferences prefs=  PreferenceManager.getDefaultSharedPreferences(PreferenceActivity.this);
            String username = prefs.getString("username", "CHANDAN");
            String passw = prefs.getString("password", "chandan12345");
            boolean checkBox = prefs.getBoolean("checkBox", false);
            String listPrefs = prefs.getString("listpref", "English");


            StringBuilder builder = new StringBuilder();
            builder.append("Username: " + username + "\n");
            builder.append("Password: " + passw + "\n");
            builder.append("Keep me logged in: " + String.valueOf(checkBox) + "\n");
            builder.append("List preference: " + listPrefs);
            data.setText(builder.toString());


        }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
    }


