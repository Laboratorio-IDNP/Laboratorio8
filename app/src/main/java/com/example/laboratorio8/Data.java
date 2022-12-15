package com.example.laboratorio8;

import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Data {

    private static String filename = "datos.txt";

    public static void writeToFile(String input, File path) {

        try {
            FileOutputStream writer = new FileOutputStream(new File(path, filename), true);
            writer.write(input.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(File path) {
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
}
