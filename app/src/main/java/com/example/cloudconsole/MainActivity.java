package com.example.cloudconsole;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.example.cloudconsole.Email.JavaMailAPI;
import com.example.cloudconsole.IAMUserActivities.IAMUser;
import com.example.cloudconsole.RootActivities.RootUser;
import com.example.cloudconsole.RootActivities.RootUserDashBoard;

public class MainActivity extends AppCompatActivity {
    CardView rootUser;
    CardView iamUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootUser=findViewById(R.id.RootUser);
        iamUser=findViewById(R.id.IAMUser);

    rootUser.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Intent intent;
            Intent intent1;
            intent1=new Intent(MainActivity.this, RootUserDashBoard.class);
            startActivity(intent1);

//          startActivity(intent);
            Log.e("SendMail123","Trying to send a Mail");




        }
    });
    iamUser.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1;
            intent1=new Intent(MainActivity.this, IAMUser.class);
            startActivity(intent1);

        }
    });




    }
}