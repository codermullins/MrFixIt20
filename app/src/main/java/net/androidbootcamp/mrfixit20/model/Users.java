package net.androidbootcamp.mrfixit20.model;

import android.content.ContentValues;

import net.androidbootcamp.mrfixit20.database.loginTable;


public class Users {

    private String id;
    private String fName;
    private String lName;
    private String email;
    private String password;

    //constructor for empty parameters
    public Users(){

    }
    // constructor for five parameters
    public Users(String id, String fName, String lName, String email, String pwd) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = pwd;
    }

    // get/set methods
    public String getfName() {return fName;}
    public void setfName(String fName) {this.fName = fName;}
    public String getlName() {return lName;}
    public void setlName(String lName) {this.lName = lName;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    // set content values for login table
    public ContentValues toValues() {
        ContentValues values = new ContentValues (5);
        values.put(loginTable.firstName, fName);
        values.put(loginTable.lastName, lName);
        values.put(loginTable.email, email);
        values.put(loginTable.password, password);
        return values;
    }

    @Override
    public String toString() {
        return "Users{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
