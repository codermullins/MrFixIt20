package net.androidbootcamp.mrfixit20.database;

public class applianceTable {
    //set variables for table columns
    public static final String COLUMN_APPLIANCE_ID = "id";
    public static final String APPLIANCE_TABLE = "appTable";
    public static final String COLUMN_APPLIANCE_MAKE = "appMake";
    public static final String COLUMN_APPLIANCE_MODEL = "appModel";
    public static final String COLUMN_APPLIANCE_SERIAL = "appSerial";
    public static final String COLUMN_APPLIANCE_TYPE = "appType";

    //method to create application table
    public static final String CREATE_APPLIANCE_TABLE =
            "CREATE TABLE " + APPLIANCE_TABLE + "(" +
                    COLUMN_APPLIANCE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_APPLIANCE_MAKE + " TEXT," +
                    COLUMN_APPLIANCE_MODEL + " TEXT," +
                    COLUMN_APPLIANCE_SERIAL + " TEXT UNIQUE," +
                    COLUMN_APPLIANCE_TYPE + " TEXT" + ")";

    //method to delete appliance table
    public static final String DROP_APPLIANCE_TABLE =
            "DROP TABLE " + APPLIANCE_TABLE;

}
