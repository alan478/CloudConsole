package com.example.cloudconsole.RootActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cloudconsole.ApiInstances.Api;
import com.example.cloudconsole.ApiInstances.ClientServer;
import com.example.cloudconsole.R;
import com.example.cloudconsole.ClassForAPI.rootUserDetails;
import com.google.gson.JsonObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RootUser extends AppCompatActivity {
    TextView createAccount;
    EditText username,password;
    CardView cV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_user);
        createAccount=findViewById(R.id.createAccount);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        cV=findViewById(R.id.cV);
//        Intent intent=new Intent(getApplicationContext(),RootUserDashBoard.class);
//
//        startActivity(intent);


        cV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonObject jsonObject=new JsonObject();
                jsonObject.addProperty("email_or_username",username.getText().toString());
                jsonObject.addProperty("password",password.getText().toString());
                Api api= ClientServer.getClientsever().create(Api.class);
                Call<rootUserDetails> call=api.getDetails(jsonObject);
                call.enqueue(new Callback<rootUserDetails>() {
                    @Override
                    public void onResponse(Call<rootUserDetails> call, Response<rootUserDetails> response) {
                        if(response.code()==200)
                        {
                            rootUserDetails userDetails=response.body();
                            Toast.makeText(getApplicationContext(),"RootUser Succesfull Logged In",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(getApplicationContext(),RootUserDashBoard.class);
                            intent.putExtra("rootuserDetails",userDetails);
                            startActivity(intent);


                        }else if(response.code()==400)
                        {
                            try {
                                Toast.makeText(getApplicationContext(),response.errorBody().string(),Toast.LENGTH_LONG).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }else if(response.code()==404){
                            try {
                                Toast.makeText(getApplicationContext(),response.errorBody().string(),Toast.LENGTH_LONG).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<rootUserDetails> call, Throwable t) {

                        Log.e("MainActivity123",t.toString());
                    }
                });



            }
        });







createAccount.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getApplicationContext(), RegisterRootUser.class);
        startActivity(intent);
    }
});

    }
}