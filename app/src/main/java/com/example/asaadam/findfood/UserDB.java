package com.example.asaadam.findfood;
import com.google.firebase.database.IgnoreExtraProperties;
/**
 * Created by jenrinaldo on 3/17/18.
 */
@IgnoreExtraProperties
public class UserDB {
    private String userID;
    private String username;
    private String password;
    private String email;
    private String name;
    public UserDB(){

    }
    public UserDB(String userID, String name,String username,String password,String email){
        this.userID = userID;
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }
}
