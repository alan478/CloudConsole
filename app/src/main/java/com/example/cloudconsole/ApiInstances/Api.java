package com.example.cloudconsole.ApiInstances;

import com.example.cloudconsole.ClassForAPI.IamUserLogin;
import com.example.cloudconsole.ClassForAPI.IamUserRegister;
import com.example.cloudconsole.ClassForAPI.rootUserDetails;
import com.example.cloudconsole.ClassForAPI.user;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface Api {


    @POST("api/rootuserregister/")
    Call<user> createUser(@Body JsonObject object);
    @POST("api/rootuserlogin/")
    Call<rootUserDetails> getDetails(@Body JsonObject object);
    @POST("api/iamuserregister/")
    Call<IamUserRegister> getIamUserDetails(
            @HeaderMap Map<String, String> headers,
            @Body JsonObject object);

    @POST("api/iamuserlogin/")
    Call<IamUserLogin> loginIamUser(@Body JsonObject object);
    @POST("vm/api/createvm")
    Call<List<String>> createANewInstance
            (
                    @HeaderMap Map<String,String> headers
            );
@POST("api/listpermissions/")
Call<List<String>> getpermisson
        (
                @HeaderMap Map<String,String> headers
        );

}
