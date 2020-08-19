package net.androidbootcamp.mrfixit20.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import net.androidbootcamp.mrfixit20.model.Users;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_FILE_NAME = "mrfixit.db";
    public static final int DB_VERSION = 1;
    SQLiteDatabase mDatabase;

    public DBHelper(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
    }

    //DBHelper to create tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(loginTable.SQL_CREATE);
        db.execSQL(applianceTable.SQL_CREATE);
        db.execSQL(partTable.SQL_CREATE);
    }

    //DBHelper to update tables
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(loginTable.SQL_DELETE);
        db.execSQL(applianceTable.SQL_DELETE);
        db.execSQL(partTable.SQL_DELETE);
        onCreate(db);
    }

    //DBHelper method to add user
    public boolean insertUser(String fName, String lName, String email, String password) {
        mDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(loginTable.firstName, fName);
        values.put(loginTable.lastName, lName);
        values.put(loginTable.email, email);
        values.put(loginTable.password, password);

        long result = mDatabase.insert(loginTable.loginTable, null, values);

        return result != -1;
    }

    //open database method
    private SQLiteDatabase openDatabase(){
        String path = DB_FILE_NAME;
        mDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        return mDatabase;
    }

    //validate user
    public Users Validate(Users email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(loginTable.loginTable, new String[]
                        {loginTable.id, loginTable.firstName, loginTable.lastName, loginTable.email, loginTable.password},
                email + "=?",
                new String[]{loginTable.email},
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            Users user1 = new Users(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

            if (loginTable.password.equalsIgnoreCase(user1.getPassword())) {
                return user1;
            }
        }

        return null;
    }

    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(loginTable.loginTable,
                new String[]{loginTable.id, loginTable.firstName, loginTable.lastName, loginTable.email, loginTable.password},
                email + "=?",
                new String[]{email},
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            return true;
        }

        return false;
    }
}
