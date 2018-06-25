package com.example.admin.providerapp.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class TodoProvider extends ContentProvider {

    public static final int TODO_CODE = 100;
    public static final int TODO_CODE_WITH_ID = 101;

    public static final UriMatcher uriMatcher = buildUriMatcher();

    private TodoHelper todoHelper;

    private static UriMatcher buildUriMatcher(){
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = TodoContract.CONTENT_AUTHORITY;

        // matches to this URI -> content://com.example.admin.providerapp/todo -> returns 100
        matcher.addURI(authority, TodoContract.TodoEntry.TABLE_NAME, TODO_CODE);
        // matches to this URI -> content://com.example.admin.providerapp/todo/2  -> returns 101
        matcher.addURI(authority, TodoContract.TodoEntry.TABLE_NAME+"/#", TODO_CODE_WITH_ID);

        return matcher;
    }

    @Override
    public boolean onCreate() {
        todoHelper = new TodoHelper(getContext());
        // you can do more steps here
//        return todoHelper != null;
        return true;
    }


    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor;

        switch (uriMatcher.match(uri)) {
            case TODO_CODE:
                cursor = todoHelper.getReadableDatabase()
                        .query(
                                TodoContract.TodoEntry.TABLE_NAME,
                                projection,
                                selection,
                                selectionArgs,
                                null,
                                null,
                                sortOrder
                        );
            default:
                throw new UnsupportedOperationException("Unknown Uri" + uri);
        }

    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final SQLiteDatabase db = todoHelper.getWritableDatabase();

        switch (uriMatcher.match(uri)) {
            case TODO_CODE:
                long _id = db.insert(TodoContract.TodoEntry.TABLE_NAME, null, values);
                if (_id != -1) {
                    getContext().getContentResolver().notifyChange(uri, null); //notify other people interacting with the dataset that this uri is no longer valid
                }
                return TodoContract.TodoEntry.buildTodoWithId(_id);
            default:
                //throw a new UnsopportedOperationException(Uri);
                return null;
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
