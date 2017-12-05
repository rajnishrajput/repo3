package com.example.cravrr.externalstoragepref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText editTextFileName, editTextData;
    Button saveButton, readButton;
    TextView display_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFileName = (EditText) findViewById(R.id.filename);
        editTextData = (EditText) findViewById(R.id.data);
        saveButton = (Button) findViewById(R.id.save_btn);
        readButton = (Button) findViewById(R.id.get_btn);
        display_data=(TextView)findViewById(R.id.display_data);

        //Performing action on save button
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String filename = editTextFileName.getText().toString();
                String data = editTextData.getText().toString();

                FileOutputStream fos;
                try {
                    File myFile = new File("/sdcard/" + filename);
                    myFile.createNewFile();
                    FileOutputStream fOut = new FileOutputStream(myFile);
                    OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                    myOutWriter.append(data);
                    myOutWriter.close();
                    fOut.close();

                    Toast.makeText(getApplicationContext(), filename + "saved successfull", Toast.LENGTH_LONG).show();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        //Performing action on Read Button
        readButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String filename = editTextFileName.getText().toString();
                StringBuffer stringBuffer = new StringBuffer();
                String aDataRow = "";
                //String aBuffer = "";
                try {
                    File myFile = new File("/sdcard/" + filename);
                    FileInputStream fIn = new FileInputStream(myFile);
                    BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));

                    while ((aDataRow = myReader.readLine()) != null) {
                        //aBuffer += aDataRow + "\n";
                        stringBuffer.append(aDataRow+"\n");
                    }
                    myReader.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                 display_data.setText(stringBuffer.toString());
                Toast.makeText(getApplicationContext(), stringBuffer.toString(), Toast.LENGTH_LONG).show();

            }

        });
    }
}