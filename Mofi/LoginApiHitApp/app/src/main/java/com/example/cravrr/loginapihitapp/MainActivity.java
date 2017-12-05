package com.example.cravrr.loginapihitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button showData;
    public static  TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showData=(Button)findViewById(R.id.showdata);
        textView=(TextView)findViewById(R.id.data);
        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               GateData gateData=new GateData();
                         gateData.execute();


            }
        });
    }

}
