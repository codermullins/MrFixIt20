package net.androidbootcamp.mrfixit20.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import net.androidbootcamp.mrfixit20.model.Appliance;
import net.androidbootcamp.mrfixit20.model.Parts;
import net.androidbootcamp.mrfixit20.model.Users;

import java.util.ArrayList;
import java.util.HashMap;


public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = "DBHelper";

    public static final String DB_FILE_NAME = "mrfixit.db";
    public static final int DB_VERSION = 1;


    public DBHelper(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
        Log.d(TAG, "DBHelper: constructor");
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
        db.execSQL(userTable.DROP_USER_TABLE);
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


    public Cursor getAllAppliances() {
        String query = "SELECT * FROM " + applianceTable.APPLIANCE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public void insertAppliance(Appliance appliance) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(applianceTable.COLUMN_APPLIANCE_MAKE, appliance.getMake());
        values.put(applianceTable.COLUMN_APPLIANCE_MODEL, appliance.getModel());
        values.put(applianceTable.COLUMN_APPLIANCE_SERIAL, appliance.getSerial());
        values.put(applianceTable.COLUMN_APPLIANCE_TYPE, appliance.getType());

        long result = db.insert(applianceTable.APPLIANCE_TABLE, null, values);
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
    public Cursor getParts(){
        String query = "SELECT * FROM " + partTable.PART_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public boolean isPartNumber(String partNumber) {
        String[] columns = { partTable.COLUMN_PART_ID };
        SQLiteDatabase db = this.getReadableDatabase();
        String sel = partTable.COLUMN_PART_NUMBER + " =?";

        String[] selArgs = {partNumber};

        Cursor cursor = db.query(partTable.PART_TABLE, columns, sel, selArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if(cursorCount > 0){
            return true;
        }
        return false;
    }

    public boolean insertPart(Parts parts) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(partTable.COLUMN_APPLIANCE_SERIAL, parts.getAppPartSerial());
        values.put(partTable.COLUMN_PART_NAME, parts.getPartName());
        values.put(partTable.COLUMN_PART_NUMBER, parts.getPartNumber());
        values.put(partTable.COLUMN_PART_COST, parts.getPartCost());
        values.put(partTable.COLUMN_PART_INVENTORY, parts.getPartInv());

        long result = db.insert(partTable.PART_TABLE, null, values);
        return result != -1;
    }

}
