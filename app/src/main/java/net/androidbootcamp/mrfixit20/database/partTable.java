package net.androidbootcamp.mrfixit20.database;

public class partTable {
    //set variables for table columns
    public static final String COLUMN_PART_ID = "id";
    public static final String PART_TABLE = "partTable";
    public static final String COLUMN_PART_NAME = "partName";
    public static final String COLUMN_PART_NUMBER = "partNumber";
    public static final String COLUMN_PART_COST = "partCost";
    public static final String COLUMN_PART_INVENTORY = "partInv";
    public static final String COLUMN_APPLIANCE_SERIAL = "appSerial";

    //method to create parts table
    public static final String CREATE_PART_TABLE =
            "CREATE TABLE " + PART_TABLE + "(" +
                    COLUMN_PART_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_PART_NAME + " TEXT," +
                    COLUMN_PART_NUMBER + " TEXT," +
                    COLUMN_PART_COST + " TEXT," +
                    COLUMN_PART_INVENTORY + " TEXT," +
                    COLUMN_APPLIANCE_SERIAL + " TEXT" + ")";

    //method to delete parts table
    public static final  String DROP_PART_TABLE =
            "DROP TABLE " + PART_TABLE;
}
