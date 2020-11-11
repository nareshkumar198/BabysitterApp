package com.example.demoproject.data;

import android.provider.BaseColumns;

public final class UserContract {

    private UserContract() {}
    public static final class UserEntry implements BaseColumns {

        public final static String TABLE_NAME = "users";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_USER_EMAIL ="email";
        public final static String COLUMN_USER_PASSWORD = "password";
        public final static String COLUMN_USER_FIRSTNAME = "firstname";
        public final static String COLUMN_USER_LASTNAME = "lastname";
        public final static String COLUMN_USER_PHONENO = "phoneno";
        public final static String COLUMN_USER_COMM_MODE = "commode";

        public static final int COMM_MODE_TEXT = 0;
        public static final int COMM_MODE_EMAIL = 1;
    }
}

