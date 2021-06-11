package com.example.cloudconsole.IAMUserActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.cloudconsole.ApiInstances.Api;
import com.example.cloudconsole.ApiInstances.ClientServer;
import com.example.cloudconsole.ClassForAPI.IamUserDetails;
import com.example.cloudconsole.ClassForAPI.IamUserLogin;
import com.example.cloudconsole.R;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IAMUser extends AppCompatActivity {
    EditText username,password;
    CardView cV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_a_m_user);
        password=findViewById(R.id.password);
        cV=findViewById(R.id.cV);
        Api api= ClientServer.getClientsever().create(Api.class);
        cV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObject object=new JsonObject();
                object.addProperty("key",password.getText().toString());
                Call<IamUserLogin> call=api.loginIamUser(object);
                call.enqueue(new Callback<IamUserLogin>() {
                    @Override
                    public void onResponse(Call<IamUserLogin> call, Response<IamUserLogin> response) {
                        if(response.code()==200)
                        {
                            IamUserLogin login= response.body();
                            Intent intent= new Intent(getApplicationContext(),IamUserDashBoard.class);
                            intent.putExtra("IamUserDetails",login);
                            startActivity(intent);

                        }
                        Log.e("IAMUser",response.code()+" "+response.raw());
                    }

                    @Override
                    public void onFailure(Call<IamUserLogin> call, Throwable t) {
                        Log.e("IAMUser",t.getMessage());
                    }
                });



            }
        });









    }
}