package com.example.todolist;

import android.content.Context;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class FileHelper {

    public static final String FILENAME = "listinfo.dat";

    public static void writeData(ArrayList<String> item, Context context){
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oas = new ObjectOutputStream(fos);
            oas.writeObject(item);
            oas.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> readData(Context context){
        ArrayList<String> itemList = null;
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemList = (ArrayList<String>) ois.readObject();
        } catch (FileNotFoundException e) {
            itemList = new ArrayList<>();
            e.printStackTrace();

//            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }

        return itemList;
    }
}
