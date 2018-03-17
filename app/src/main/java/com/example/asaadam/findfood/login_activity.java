package com.example.asaadam.findfood;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login_activity extends AppCompatActivity {
    Button button;
    EditText userLogin,passwordRegist;
    TextView signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        userLogin = findViewById(R.id.userLogin);
        passwordRegist = findViewById(R.id.passwordLogin);
        button = findViewById(R.id.singIn);
        signUp = findViewById(R.id.signUP);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("user");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(login_activity.this);
                mDialog.setMessage("Please Wating...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(TextUtils.isEmpty(userLogin.getText().toString().trim())){
                            mDialog.dismiss();
                            Toast.makeText(login_activity.this,"Please enter username",Toast.LENGTH_LONG).show();
                            return;
                        }else if(TextUtils.isEmpty(passwordRegist.getText().toString().trim())){
                            mDialog.dismiss();
                            Toast.makeText(login_activity.this,"Please enter password",Toast.LENGTH_LONG).show();
                            return;
                        } else {
                            //check if user not exist in database
                            if(dataSnapshot.child("info").child(userLogin.getText().toString()).exists()) {
                                //get user information
                                mDialog.dismiss();
                                UserDB user = dataSnapshot.child("info").child(userLogin.getText().toString()).getValue(UserDB.class);
                                user.setUsername(userLogin.getText().toString());
                                if (user.getPassword().equals(passwordRegist.getText().toString())) {

                                    Intent homeIntent = new Intent(login_activity.this, MenuList.class);
                                    Common.currentUser = user;
                                    startActivity(homeIntent);
                                    finish();

                                } else {
                                    Toast.makeText(login_activity.this, "Wrong Password !", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(login_activity.this, userLogin.getText().toString().trim().concat(" is not exist in Database"), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                Intent sign = new Intent(login_activity.this, Regist.class);
                                startActivity(sign);
                                finish();

                            }
                });
    }
}

