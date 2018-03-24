package com.example.asaadam.findfood;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asaadam.findfood.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SignUp";
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
        setContentView(R.layout.activity_signup);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseUser = FirebaseDatabase.getInstance().getReference();
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
        if (!validateForm()) {
            return;
        }
            progressDialog.setMessage("Registering Please Wait...");
            progressDialog.show();
            String email = emailRegist.getText().toString().trim();
            String password  = passwordRegist.getText().toString().trim();
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                onAuthSuccess(task.getResult().getUser());
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(SignUp.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });
            progressDialog.dismiss();

    }
    private boolean validateForm() {
        boolean result = true;
        if (TextUtils.isEmpty(emailRegist.getText().toString())) {
            emailRegist.setError("Required");
            result = false;
        } else {
            emailRegist.setError(null);
        }

        if (TextUtils.isEmpty(passwordRegist.getText().toString())) {
            passwordRegist.setError("Required");
            result = false;
        } else {
            passwordRegist.setError(null);
        }
        if (TextUtils.isEmpty(usernameRegist.getText().toString())) {
            usernameRegist.setError("Required");
            result = false;
        } else {
            usernameRegist.setError(null);
        }

        if (TextUtils.isEmpty(nameRegist.getText().toString())) {
            nameRegist.setError("Required");
            result = false;
        } else {
            nameRegist.setError(null);
        }
        return result;
    }
    private void onAuthSuccess(FirebaseUser user) {
        String email = emailRegist.getText().toString().trim();
        String username = usernameRegist.getText().toString().trim();
        String name = nameRegist.getText().toString().trim();
        String id = user.getUid();
        User users = new User(name, username,email);
        databaseUser.child("users").child(id).setValue(users);
        // Go to MainActivity
        startActivity(new Intent(SignUp.this, SignIn.class));
        finish();
    }
    @Override
    public void onClick(View v) {
        if(v == button) {
            registerUser();
        }
        if(v == already){
            Intent login = new Intent(SignUp.this,SignIn.class);
            startActivity(login);
        }
    }
}
