package net.androidbootcamp.mrfixit20.database;

public class applianceTable {
    //set variables for table columns
    public static final String id = "id";
    public static final String applianceTable = "appTable";
    public static final String make = "appMake";
    public static final String model = "appModel";
    public static final String serial = "appSerial";
    public static final String type = "appType";

    //method to create application table
    public static final String SQL_CREATE =
            "CREATE TABLE " + applianceTable + "(" +
                    id + " INTEGER PRIMARY KEY," +
                    make + " TEXT," +
                    model + " TEXT," +
                    serial + " TEXT," +
                    type + " TEXT" + ");";

    //method to delete appliance table
    public static final String SQL_DELETE =
            "DROP TABLE " + applianceTable;

}
