package com.example.admin.providerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.admin.providerapp.data.TodoContract;
import com.example.admin.providerapp.data.TodoHelper;

public class MainActivity extends AppCompatActivity {

//    Uri Universal Resource Identifier
//    content://content_authority/table_name
//    URL -> Universal Resource Link
//    http://webdomain/path/to/resource.html


    //    instead of writing queries all over the palce wherever i need it, you can use the contentprovider
/*
    TodoHelper helper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new TodoHelper(this);
        database = helper.getWritableDatabase();
    }



    //you would need a query each time you would need to
    private void readFromDb() {
        database.query();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (database != null) {
            database.close();
        }

        helper = null;
    }*/

    public static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void insertTodo(String task) {

        //This method would be your own class, that would be the repository
        //With this you make an insert
        ContentValues values = new ContentValues();
        values.put(TodoContract.TodoEntry.COLUMN_TASK, task);
        values.put(TodoContract.TodoEntry.COLUMN_STATUS, 0);
        values.put(TodoContract.TodoEntry.COLUMN_DATE, System.currentTimeMillis());
        getContentResolver().insert(TodoContract.TodoEntry.CONTENT_URI, values);
    }

    private Cursor getTask() {
        Cursor cursor = getContentResolver()
                .query(TodoContract.TodoEntry.CONTENT_URI,
                        null,
                        null,
                        null,
                        null);


//        how to loop
/*        if (cursor.moveToFirst()) {
            do {
                String task = cursor.getString(
                        cursor.getColumnIndex(
                                TodoContract.TodoEntry.COLUMN_TASK
                        ));
                Log.d(TAG, "getTask: ");
            } while (cursor.moveToNext());
        }*/

        return cursor;
    }



}
