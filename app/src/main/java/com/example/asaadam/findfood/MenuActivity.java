package com.example.asaadam.findfood;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.example.asaadam.findfood.models.User;
import com.example.asaadam.findfood.viewholder.MenuAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

/**
 * Created by asaadam on 3/14/2018.
 */

public class MenuActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MenuActivity";
    private EditText editText;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    TextView nameLogin;
    TextView emailLogin;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SpecialHariIni menus = new SpecialHariIni();
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Menu");
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //Set Adapter
        MenuAdapter adapter = new MenuAdapter(this, menus.initData());
        //Find recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //Set Name for user
        View headerView = navigationView.getHeaderView(0);
        emailLogin = headerView.findViewById(R.id.emailLogin);
        nameLogin = headerView.findViewById(R.id.post_author);
        //Set Adapter to list View
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //Find edit text
        editText=(EditText)findViewById(R.id.editText);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
            }
        });
        final String userId = getUid();
        mDatabase.child("users").child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                nameLogin.setText(dataSnapshot.child("name").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        setNameUser();
    }
    public void setNameUser(){
        // [START single_value_read]
        emailLogin.setText(getMail());
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_add) {
            Intent add_recipe = new Intent(MenuActivity.this, NewPostActivity.class);
            startActivity(add_recipe);
            return true;
        } else if (id == R.id.nav_myrecipe) {
            Intent all_recipe = new Intent(MenuActivity.this, MyRecipeActivity.class);
            startActivity(all_recipe);
            return true;

        } else if (id == R.id.nav_setting) {
            Intent acc_setting = new Intent(MenuActivity.this, SettingsActivity.class);
            startActivity(acc_setting);

        } else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(MenuActivity.this, SignIn.class));
            finish();
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
