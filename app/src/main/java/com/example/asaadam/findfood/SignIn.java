package com.example.asaadam.findfood;

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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SignIn";
    private Button button;
    private EditText userLogin,passwordRegist;
    private TextView signUp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mAuth = FirebaseAuth.getInstance();
        userLogin = findViewById(R.id.userLogin);
        passwordRegist = findViewById(R.id.passwordLogin);
        button = findViewById(R.id.singIn);
        signUp = findViewById(R.id.signUP);

        button.setOnClickListener(this);
        signUp.setOnClickListener(this);
    }
    public void signIn(){
        String email = userLogin.getText().toString();
        String password = passwordRegist.getText().toString();
        if (!validateForm()) {
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signIn:onComplete:" + task.isSuccessful());

                        if (task.isSuccessful()) {
                            FirebaseUser currentUser = mAuth.getCurrentUser();
                            Intent login = new Intent(SignIn.this,MenuList.class);
                            startActivity(login);
                        } else {
                            Toast.makeText(SignIn.this, "Sign In Failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private boolean validateForm() {
        boolean result = true;
        if (TextUtils.isEmpty(userLogin.getText().toString())) {
            userLogin.setError("Required");
            result = false;
        } else {
            userLogin.setError(null);
        }

        if (TextUtils.isEmpty(passwordRegist.getText().toString())) {
            passwordRegist.setError("Required");
            result = false;
        } else {
            passwordRegist.setError(null);
        }

        return result;
    }
    @Override
    public void onClick(View v) {
        if(v == button) {
            signIn();
        }
        if(v == signUp){
            Intent daftar = new Intent(SignIn.this,SignUp.class);
            startActivity(daftar);
        }
    }
}

