package com.example.admin.providerapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TodoHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mytodo.db";
    public static final int DATABASE_VERSION = 1;

    public TodoHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_TODO_TABLE =
                "CREATE TABLE " + TodoContract.TodoEntry.TABLE_NAME + " (" +
                    TodoContract.TodoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TodoContract.TodoEntry.COLUMN_DATE + " INTEGER NOT NULL, " +
                    TodoContract.TodoEntry.COLUMN_TASK + " TEXT NOT NULL, " +
                    TodoContract.TodoEntry.COLUMN_STATUS + " INTEGER NOT NULL);";

        db.execSQL((SQL_CREATE_TODO_TABLE));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //handle data migration from the old schema to the new schema
        //when the version is upgraded, also theres anothe method, downgrade
        db.execSQL("DROP TABLE IF EXISTS " + TodoContract.TodoEntry.TABLE_NAME);
        onCreate(db);
    }
}
