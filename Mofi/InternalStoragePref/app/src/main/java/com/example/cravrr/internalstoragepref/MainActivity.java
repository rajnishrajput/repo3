package com.example.cravrr.internalstoragepref;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText filename1, data;
    TextView setData;
    Button save, get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filename1 =(EditText)findViewById(R.id.filename);
             data=(EditText)findViewById(R.id.data);
        save=(Button)findViewById(R.id.save_btn);
        get=(Button)findViewById(R.id.get_btn);
        setData=(TextView)findViewById(R.id.display_data);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String filename_str=filename1.getText().toString();
                String data_str=data.getText().toString();
                FileOutputStream fileOutputStream;

                try {
                    fileOutputStream=openFileOutput(filename_str, Context.MODE_PRIVATE);
                    fileOutputStream.write(data_str.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(getApplicationContext(),filename_str+"Saved Successfull",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        get.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                String filename=filename1.getText().toString();
                StringBuffer stringBuffer = new StringBuffer();

                try {
                    //Attaching BufferedReader to the FileInputStream by the help of InputStreamReader
                    BufferedReader inputReader = new BufferedReader(new InputStreamReader(openFileInput(filename)));
                    String inputString;
                    while ((inputString = inputReader.readLine()) != null) {
                        stringBuffer.append(inputString + "\n");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                setData.setText(stringBuffer.toString());


            }

        });



}
}
