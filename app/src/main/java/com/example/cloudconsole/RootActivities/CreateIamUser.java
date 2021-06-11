package com.example.cloudconsole.RootActivities;

import android.app.Activity;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cloudconsole.ApiInstances.Api;
import com.example.cloudconsole.ApiInstances.ClientServer;
import com.example.cloudconsole.ClassForAPI.IamUserRegister;
import com.example.cloudconsole.ClassForAPI.rootUserDetails;
import com.example.cloudconsole.Email.JavaMailAPI;
import com.example.cloudconsole.IAMUserActivities.IAMUser;
import com.example.cloudconsole.R;
import com.example.cloudconsole.RoomDatabase.AppDatabase;
import com.example.cloudconsole.RoomDatabase.CartDao;
import com.example.cloudconsole.RoomDatabase.CartItem;
import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CreateIamUser extends Fragment {
    EditText username,password;
    CardView cV;
    HashMap<String,String> header;
    rootUserDetails details;



    public CreateIamUser() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_create_iam_user, container, false);
        username=view.findViewById(R.id.username);
        password=view.findViewById(R.id.password);
        cV=view.findViewById(R.id.cV);
        header=new HashMap<>();
        RootUserDashBoard activity= (RootUserDashBoard) getActivity();
        details=activity.getDetails();
        String token="Token "+details.getToken();
        header.put("Authorization",token);

        AppDatabase db = Room.databaseBuilder(getContext(),
                AppDatabase.class, "IAM").allowMainThreadQueries().build();


        cV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObject jsonObject=new JsonObject();
                jsonObject.addProperty("email",username.getText().toString());
                jsonObject.addProperty("name",password.getText().toString());
                Api api= ClientServer.getClientsever().create(Api.class);
                Call<IamUserRegister> call =api.getIamUserDetails(header,jsonObject);
                call.enqueue(new Callback<IamUserRegister>() {
                    @Override
                    public void onResponse(Call<IamUserRegister> call, Response<IamUserRegister> response) {
                        if(response.code()==200){
                        IamUserRegister register=response.body();
                            CartDao dao=db.cartDao();
                            CartItem item=new CartItem(register.getKey(),token,password.getText().toString());
                            dao.insertCartItem(item);


                        JavaMailAPI javaMailAPI = new JavaMailAPI(getContext(),username.getText().toString(), "Access Key Token", "Your AccessKey is"+register.getKey());

                        javaMailAPI.execute();
                            Toast.makeText(getContext(),"IAM user Created",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<IamUserRegister> call, Throwable t) {

                    }
                });


            }
        });
        return view;
    }
}