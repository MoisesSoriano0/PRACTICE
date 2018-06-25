package com.example.admin.providerapp.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class TodoContract {

    private TodoContract() {
    }

    public static final String CONTENT_AUTHORITY =
            "com.example.admin.providerapp";

    public static final Uri BASE_CONTENT_URI =
            Uri.parse("content//" + CONTENT_AUTHORITY);

//    SQLite table contract
    public static final class TodoEntry implements BaseColumns {
        public static final String TABLE_NAME = "todo";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TASK = "task";
        public static final String COLUMN_STATUS = "status";

    //Content provider stuff
    // content://com.example.providerapp/todo
    public static final Uri CONTENT_URI =
            BASE_CONTENT_URI.buildUpon()
                    .appendPath(TABLE_NAME)
                    .build();

    // content://com.example.providerapp/todo/20
    public static Uri buildTodoWithId(long id) {
        return CONTENT_URI
                .buildUpon()
                .appendPath(Long.toString(id))
                .build();
    }

    }

}
