package com.example.cravrr.testapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.cravrr.testapp.R;

public class MainActivity extends Activity implements OnClickListener {
    Button buttonStart, buttonStop,buttonNext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = (Button) findViewById(R.id.start);
        buttonStop = (Button) findViewById(R.id.stop);
        buttonNext = (Button) findViewById(R.id.next);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.start:
                startService(new Intent(this, MyService.class));
                break;
            case R.id.stop:
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.next:
                Intent intent=new Intent(this,NextPage.class);
                startActivity(intent);
                break;
        }
    }
}
