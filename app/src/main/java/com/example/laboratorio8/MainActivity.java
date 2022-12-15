package com.example.laboratorio8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText textInput;
    Button buttonWrite;
    Button buttonRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInput = findViewById(R.id.textInput);
        buttonWrite = findViewById(R.id.buttonWrite);
        buttonRead = findViewById(R.id.buttonRead);

        buttonWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = textInput.getText().toString() + "\n";
                writeToFile("datos.txt", input);
            }
        });

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data =  readFromFile("datos.txt");
                Log.i("DATA", data);
            }
        });
    }

    private String readFromFile(String filename) {
        File path = getApplicationContext().getFilesDir();
        File readFrom = new File(path, filename);
        byte[] data = new byte[(int) readFrom.length()] ;
        try {
            FileInputStream stream =  new FileInputStream(readFrom);
            stream.read(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
        return new String(data);
    }

    private void writeToFile(String filename, String input) {
        File path = getApplicationContext().getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, filename), true);
            writer.write(input.getBytes());
            Toast.makeText(getApplicationContext(), "Guardado" , Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}