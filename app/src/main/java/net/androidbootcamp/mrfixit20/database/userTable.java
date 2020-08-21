package net.androidbootcamp.mrfixit20.database;

public class userTable {
    //set variables for table columns
    public static final String COLUMN_USER_ID = "userID";
    public static final String USER_TABLE = "userTable";
    public static final String COLUMN_USER_FNAME = "firstName";
    public static final String COLUMN_USER_LNAME = "lastName";
    public static final String COLUMN_USER_EMAIL = "email";
    public static final String COLUMN_USER_PASSWORD = "password";


    public static final String CREATE_USER_TABLE =
            "CREATE TABLE " + USER_TABLE + "(" +
                    COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_USER_FNAME + " TEXT," +
                    COLUMN_USER_LNAME + " TEXT," +
                    COLUMN_USER_EMAIL + " TEXT," +
                    COLUMN_USER_PASSWORD + " TEXT" + ")";

    public static final String SQL_DELETE =
            "DROP TABLE " + USER_TABLE;
}
