package net.androidbootcamp.mrfixit20.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import net.androidbootcamp.mrfixit20.model.Appliance;
import net.androidbootcamp.mrfixit20.model.Users;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {


    private static final String DB_FILE_NAME = "mrfixit.db";
    private static final int DB_VERSION = 1;

    //Drop table if exists
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + userTable.USER_TABLE;

    public DBHelper(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
    }

    //DBHelper to create tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(userTable.CREATE_USER_TABLE);
        db.execSQL(applianceTable.CREATE_APPLIANCE_TABLE);
        db.execSQL(partTable.CREATE_PART_TABLE);
    }

    //DBHelper to update tables
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);
        db.execSQL(applianceTable.DROP_APPLIANCE_TABLE);
        db.execSQL(partTable.DROP_PART_TABLE);
        onCreate(db);
    }

    //DBHelper method to add user
    public boolean insertUser(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(userTable.COLUMN_USER_FNAME, users.getfName());
        values.put(userTable.COLUMN_USER_LNAME, users.getlName());
        values.put(userTable.COLUMN_USER_EMAIL, users.getEmail());
        values.put(userTable.COLUMN_USER_PASSWORD, users.getPassword());

        long result = db.insert(userTable.USER_TABLE, null, values);
        return result != -1;
    }

    //open database method
//    private SQLiteDatabase openDatabase(){
//        String path = DB_FILE_NAME;
//        mDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
//        return mDatabase;
//    }

    //validate user
    public boolean Validate(String email, String password) {
        String[] columns = {userTable.COLUMN_USER_ID};
        SQLiteDatabase db = this.getReadableDatabase();

        String sel = userTable.COLUMN_USER_EMAIL + " =?" + " AND " + userTable.COLUMN_USER_PASSWORD + " =?";
        String[] selArgs = {email, password};
        Cursor cursor = db.query(userTable.USER_TABLE, columns, sel, selArgs, null, null, null);

        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }
        return false;
    }


    public boolean isEmailExists(String email) {
        String[] columns = { userTable.COLUMN_USER_ID };
        SQLiteDatabase db = this.getReadableDatabase();
        String sel = userTable.COLUMN_USER_EMAIL + " =?";

        String[] selArgs = {email};

        Cursor cursor = db.query(userTable.USER_TABLE, columns, sel, selArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if(cursorCount > 0){
            return true;
        }
        return false;
    }

    // Get appliances
    public ArrayList<HashMap<String, String>> GetAppliances(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> app_list = new ArrayList<>();
        String query = "SELECT " + applianceTable.COLUMN_APPLIANCE_MAKE + ", " + applianceTable.COLUMN_APPLIANCE_MODEL + ", " + applianceTable.COLUMN_APPLIANCE_SERIAL +
                ", " + applianceTable.COLUMN_APPLIANCE_TYPE + " FROM " + applianceTable.APPLIANCE_TABLE;

        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            HashMap<String, String> appliance = new HashMap<>();
            appliance.put("make", cursor.getString(cursor.getColumnIndex(applianceTable.COLUMN_APPLIANCE_MAKE)));
            appliance.put("model", cursor.getString(cursor.getColumnIndex(applianceTable.COLUMN_APPLIANCE_MODEL)));
            appliance.put("serial", cursor.getString(cursor.getColumnIndex(applianceTable.COLUMN_APPLIANCE_SERIAL)));
            appliance.put("type", cursor.getString(cursor.getColumnIndex(applianceTable.COLUMN_APPLIANCE_TYPE)));
            app_list.add(appliance);
        }
        return app_list;
    }

    public boolean insertAppliance(Appliance appliance) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(applianceTable.COLUMN_APPLIANCE_MAKE, appliance.getMake());
        values.put(applianceTable.COLUMN_APPLIANCE_MODEL, appliance.getModel());
        values.put(applianceTable.COLUMN_APPLIANCE_SERIAL, appliance.getSerial());
        values.put(applianceTable.COLUMN_APPLIANCE_TYPE, appliance.getType());

        long result = db.insert(applianceTable.APPLIANCE_TABLE, null, values);
        return result != -1;
    }

    public boolean isSerialExists(String serial) {
        String[] columns = { applianceTable.COLUMN_APPLIANCE_ID };
        SQLiteDatabase db = this.getReadableDatabase();
        String sel = applianceTable.COLUMN_APPLIANCE_SERIAL + " =?";

        String[] selArgs = {serial};

        Cursor cursor = db.query(applianceTable.APPLIANCE_TABLE, columns, sel, selArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if(cursorCount > 0){
            return true;
        }
        return false;
    }

    //Get Part List
    public ArrayList<HashMap<String, String>> GetParts(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> part_list = new ArrayList<>();
        String query = "SELECT " + partTable.COLUMN_PART_ID + ", " + partTable.COLUMN_PART_NAME + ", " + partTable.COLUMN_PART_NUMBER +
                ", " + partTable.COLUMN_PART_COST + ", " + partTable.COLUMN_PART_INVENTORY + ", " + partTable.COLUMN_APPLIANCE_SERIAL +
                " FROM "+ partTable.PART_TABLE;

        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            HashMap<String, String> parts = new HashMap<>();
            parts.put("partName", cursor.getString(cursor.getColumnIndex(partTable.COLUMN_PART_NAME)));
            parts.put("partNumber", cursor.getString(cursor.getColumnIndex(partTable.COLUMN_PART_NUMBER)));
            parts.put("partCost", cursor.getString(cursor.getColumnIndex(partTable.COLUMN_PART_COST)));
            parts.put("partInv", cursor.getString(cursor.getColumnIndex(partTable.COLUMN_PART_INVENTORY)));
            part_list.add(parts);
        }
        return part_list;
    }

}
