package com.example.asaadam.findfood;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;
import java.util.List;
public class Regist extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private EditText emailRegist;
    private EditText passwordRegist;
    private EditText nameRegist;
    private EditText usernameRegist;
    private TextView already;
    DatabaseReference databaseUser;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseUser = FirebaseDatabase.getInstance().getReference("user");
        progressDialog = new ProgressDialog(this);
        button = (Button) findViewById(R.id.button);
        nameRegist = (EditText) findViewById(R.id.nameRegist);
        usernameRegist = (EditText) findViewById(R.id.usernameRegist);
        emailRegist = (EditText) findViewById(R.id.emailRegist);
        passwordRegist = (EditText) findViewById(R.id.passwordRegist);
        already = (TextView) findViewById(R.id.already);
        button.setOnClickListener(this);
        already.setOnClickListener(this);
    }
    private void registerUser(){
        String email = emailRegist.getText().toString().trim();
        String password  = passwordRegist.getText().toString().trim();
        String username = usernameRegist.getText().toString().trim();
        String name = nameRegist.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this,"Please enter username",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Please enter name",Toast.LENGTH_LONG).show();
            return;
        }
        if (!TextUtils.isEmpty(name)) {
            progressDialog.setMessage("Registering Please Wait...");
            progressDialog.show();
            String id = databaseUser.push().getKey();
            UserDB users = new UserDB(id, name, username,password,email);
            databaseUser.child("info").child(username).setValue(users);
            emailRegist.setText("");
            nameRegist.setText("");
            passwordRegist.setText("");
            usernameRegist.setText("");
            Toast.makeText(this, "Registered successfully", Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
        } else {
            Toast.makeText(this, "Registered Failed", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onClick(View v) {
        if(v == button) {
            registerUser();
        }
        if(v == already){
            Intent login = new Intent(Regist.this,login_activity.class);
            startActivity(login);
        }
    }
}
