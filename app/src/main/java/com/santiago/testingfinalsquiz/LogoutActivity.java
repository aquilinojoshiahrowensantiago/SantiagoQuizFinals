package com.santiago.testingfinalsquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LogoutActivity extends AppCompatActivity {
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        user=b.getString("user");
    }
    public void onStart(){
        super.onStart();
        TextView view=(TextView)findViewById(R.id.txtuser);
        view.setText(user);
    }


    public void logout(View view){
        SharedPreferences sharedPrefs =getSharedPreferences(MainActivity.PREFS_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.clear();
        editor.commit();
        user="";
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

