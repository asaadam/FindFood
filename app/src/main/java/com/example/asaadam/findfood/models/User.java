package com.example.asaadam.findfood.models;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.IgnoreExtraProperties;
/**
 * Created by jenrinaldo on 3/17/18.
 */
@IgnoreExtraProperties
public class User {
    public String username;
    public String email;
    public String name;
    public User(Object value) {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }
    public User(String name, String username, String email){
        this.email = email;
        this.name = name;
        this.username = username;
    }

}
