package com.example.cravrr.loginapihitapp;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Cravrr on 11/18/2017.
 */

public class GateData extends AsyncTask<Void, Void, Void> {
    String line="", data="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url=new URL("https://api.myjson.com/bins/1bl5wb");
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

            while (line!=null){

                line=bufferedReader.readLine();
                data=data+line;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.textView.setText(data);

    }
}
