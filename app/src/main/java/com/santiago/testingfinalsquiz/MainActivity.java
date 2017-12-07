package com.santiago.testingfinalsquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String  PREFS_NAME="mypre";
    public static String PREF_USERNAME="username";
    public static String PREF_PASSWORD="password";
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }

    public void onStart(){
        super.onStart();
        getUser();
    }

    public void doLogin(View view){
        EditText txtuser=(EditText)findViewById(R.id.txt_user);
        EditText txtpwd=(EditText)findViewById(R.id.txt_pwd);
        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //SharedPreferences.Editor editor = preferences.edit();
        //editor.putString("username",txtuser.getText().toString());
        //editor.putString("password",txtpwd.getText().toString());
        String username= "username";
        String password= "password";
        //editor.apply();
        if(txtuser.getText().toString().equals(username) && txtpwd.getText().toString().equals(password)){
            Button ch=(Button) findViewById(R.id.btn_rememberme);

            if(ch.isSelected())
                rememberMe(username,password);
            showLogout(username);
            Toast.makeText(this, "Username and Password Correct", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_LONG).show();
        }


    }

    public void getUser(){
        SharedPreferences pref = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String username = pref.getString(PREF_USERNAME, null);
        String password = pref.getString(PREF_PASSWORD, null);

        if (username != null || password != null) {
            showLogout(username);
        }
    }

    public void rememberMe(String user, String password){
        //save username and password in SharedPreferences
        getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                .edit()
                .putString(PREF_USERNAME,user)
                .putString(PREF_PASSWORD,password)
                .commit();
    }

    public void showLogout(String username){
        //display log out activity
        Intent intent=new Intent(this, LogoutActivity.class);
        intent.putExtra("user",username);
        startActivity(intent);
    }



}
