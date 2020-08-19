package net.androidbootcamp.mrfixit20.database;

public class partTable {
    //set variables for table columns
    public static final String id = "id";
    public static final String partTable = "partTable";
    public static final String partNumber = "partNumber";
    public static final String partName = "partName";
    public static final String partCost = "partCost";

    //method to create parts table
    public static final String SQL_CREATE =
            "CREATE TABLE " + partTable + "(" +
                    id + " INTEGER PRIMARY KEY," +
                    partNumber + " TEXT," +
                    partName + " TEXT," +
                    partCost + " TEXT" + ");";

    //method to delete parts table
    public static final  String SQL_DELETE =
            "DROP TABLE " + partTable;
}
