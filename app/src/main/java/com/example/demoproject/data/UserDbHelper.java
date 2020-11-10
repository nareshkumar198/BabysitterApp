package com.example.demoproject.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.demoproject.data.UserContract.UserEntry;

public class UserDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = UserDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "user.db";
    private static final int DATABASE_VERSION = 1;

    public UserDbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the userss table
        String SQL_CREATE_USERS_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + UserEntry.COLUMN_USER_EMAIL + " TEXT NOT NULL, "
                + UserEntry.COLUMN_USER_PASSWORD + " TEXT NOT NULL, "
                + UserEntry.COLUMN_USER_FIRSTNAME + " TEXT NOT NULL, "
                + UserEntry.COLUMN_USER_LASTNAME + " TEXT NOT NULL, "
                + UserEntry.COLUMN_USER_PHONENO + " INTEGER NOT NULL, "
                + UserEntry.COLUMN_USER_COMM_MODE + " INTEGER NOT NULL );";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USERS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
        db.execSQL("DROP TABLE IF EXISTS "+ UserEntry.TABLE_NAME);
        onCreate(db);
    }

}