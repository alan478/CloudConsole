package com.example.cloudconsole.RootActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cloudconsole.ApiInstances.Api;
import com.example.cloudconsole.ApiInstances.ClientServer;
import com.example.cloudconsole.R;
import com.example.cloudconsole.ClassForAPI.user;
import com.google.gson.JsonObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterRootUser extends AppCompatActivity {
    EditText username,password,emailID,name;
    CardView cV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_root_user);

        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        username=findViewById(R.id.username);
        emailID=findViewById(R.id.email_id);
        cV=findViewById(R.id.cV);


cV.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        register(username.getText().toString(), password.getText().toString(), emailID.getText().toString(), name.getText().toString());
    }
});




    }

    public void register(String username,String password,String email,String name)
    {
        JsonObject postParam = new JsonObject();
        postParam.addProperty("password",password) ;
        postParam.addProperty("username",username) ;
        postParam.addProperty("email",email) ;
        postParam.addProperty("name",name) ;
        Api api= ClientServer.getClientsever().create(Api.class);
        Call<user> call=api.createUser(postParam);
        call.enqueue(new Callback<user>() {
            @Override
            public void onResponse(Call<user> call, Response<user> response) {

                user a=response.body();
                if (response.code()==200){
                    Log.e("response",a.result.toString()+a.result.get(0));
                    Toast.makeText(getApplicationContext(),a.result.get(0),Toast.LENGTH_SHORT).show();

                } else {
                    try {
                        Toast.makeText(getApplicationContext(),response.errorBody().string(),Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }

            @Override
            public void onFailure(Call<user> call, Throwable t) {
                Log.e("MainActivity123",t.toString());
            }
        });

    }



}