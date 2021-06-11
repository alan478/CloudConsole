package com.example.cloudconsole.IAMUserActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.cloudconsole.ApiInstances.Api;
import com.example.cloudconsole.ApiInstances.ClientServer;
import com.example.cloudconsole.ClassForAPI.IamUserDetails;
import com.example.cloudconsole.ClassForAPI.IamUserLogin;
import com.example.cloudconsole.R;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IamUserDashBoard extends AppCompatActivity {

    IamUserLogin details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iam_user_dash_board);
details= (IamUserLogin) getIntent().getSerializableExtra("IamUserDetails");
        Api api= ClientServer.getClientsever().create(Api.class);
        HashMap<String,String> header=new HashMap<>();
header.put("Authorization","Token "+"1c0da7716865768de4c68f5ceeead66f5c6a9b00");
        Call<List<String>> call=api.getpermisson(header);
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                Log.e("IAM","[\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"name\": \"Can delete log entry\",\n" +
                        "        \"codename\": \"delete_logentry\",\n" +
                        "        \"content_type\": 1\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 4,\n" +
                        "        \"name\": \"Can view log entry\",\n" +
                        "        \"codename\": \"view_logentry\",\n" +
                        "        \"content_type\": 1\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 9,\n" +
                        "        \"name\": \"Can add group\",\n" +
                        "        \"codename\": \"add_group\",\n" +
                        "        \"content_type\": 3\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 11,\n" +
                        "        \"name\": \"Can delete group\",\n" +
                        "        \"codename\": \"delete_group\",\n" +
                        "        \"content_type\": 3\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 45,\n" +
                        "        \"name\": \"Can add token\",\n" +
                        "        \"codename\": \"add_tokenproxy\",\n" +
                        "        \"content_type\": 12\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 29,\n" +
                        "        \"name\": \"Can add iam user\",\n" +
                        "        \"codename\": \"add_iamuser\",\n" +
                        "        \"content_type\": 8\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 33,\n" +
                        "        \"name\": \"Can add root user\",\n" +
                        "        \"codename\": \"add_rootuser\",\n" +
                        "        \"content_type\": 9\n" +
                        "    }\n" +
                        "]");
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.e("IAM",t.getMessage());
            }
        });



    }
}