package net.androidbootcamp.mrfixit20.model;

import android.content.ContentValues;

import net.androidbootcamp.mrfixit20.database.userTable;


public class Users {

    private int id;
    private String fName;
    private String lName;
    private String email;
    private String password;

    //constructor for empty parameters
    public Users(){

    }
    // constructor for five parameters
    public Users(String fName, String lName, String email, String pwd) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = pwd;
    }

    // get/set methods
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getfName() {return fName;}
    public void setfName(String fName) {this.fName = fName;}
    public String getlName() {return lName;}
    public void setlName(String lName) {this.lName = lName;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}


}
