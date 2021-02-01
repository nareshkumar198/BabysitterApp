package com.example.demoproject.data;

import android.provider.BaseColumns;

public final class UserContract {

    private UserContract() {}
    public static final class UserEntry implements BaseColumns {

        public final static String TABLE_NAME = "users";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_USER_EMAIL ="email";
        public final static String COLUMN_USER_FIRSTNAME = "firstname";
        public final static String COLUMN_USER_LASTNAME = "lastname";
        public final static String COLUMN_USER_PHONE = "phone";
        public final static String COLUMN_USER_COMM_MODE = "commode";

        public final static String COLUMN_USER_TOKEN = "token";
        public final static String COLUMN_USER_REFRESH_TOKEN = "refreshToken";
        public final static String COLUMN_USER_EXPIRY = "expiry";

        public final static String COLUMN_USER_PROVIDER = "provider";
        public final static String COLUMN_USER_PHOTO_URL = "photourl";
        public final static String COLUMN_USER_SOCIALID = "socialId";

        public final static String COLUMN_USER_ZIPCODE = "zipcode";
        public final static String COLUMN_USER_CITY = "city";
        public final static String COLUMN_USER_STATE = "state";
        public final static String COLUMN_USER_TIMEZONE_ID = "timezoneId";
        public final static String COLUMN_USER_TIMEZONE_IDENTIFIER = "timezoneIdentifier";
        public final static String COLUMN_USER_TIMEZONE_ABBR = "timezoneAbbr";
        public final static String COLUMN_USER_TIMEZONE_UTCOFFSET = "timezoneUtc";
        public final static String COLUMN_USER_TIMEZONE_IS_DST = "timezoneIsDst";

        public static final int COMM_MODE_TEXT = 0;
        public static final int COMM_MODE_EMAIL = 1;
    }
}

