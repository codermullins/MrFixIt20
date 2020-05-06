package net.androidbootcamp.mrfixit20.database;

public class loginTable {
    //set variables for table columns
    public static final String id = "id";
    public static final String loginTable = "loginTable";
    public static final String firstName = "firstName";
    public static final String lastName = "lastName";
    public static final String email = "email";
    public static final String password = "password";

    //method to create login table
    public static final String SQL_CREATE =
            "CREATE TABLE " + loginTable + "(" +
                    id + " INTEGER PRIMARY KEY," +
                    firstName + " TEXT," +
                    lastName + " TEXT," +
                    email + " TEXT," +
                    password + " TEXT" + ");";

    //method to delete login table
    public static final String SQL_DELETE =
            "DROP TABLE " + loginTable;

}
