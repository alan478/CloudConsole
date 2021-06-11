package com.example.cloudconsole.RootActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cloudconsole.Adapters.DrawerViewAdapter;
import com.example.cloudconsole.ApiInstances.Api;
import com.example.cloudconsole.ApiInstances.ClientServer;
import com.example.cloudconsole.ClassForAPI.rootUserDetails;
import com.example.cloudconsole.IAMDetails;
import com.example.cloudconsole.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SlidingDrawe extends Fragment {
    ListView lv;
    String[] array={"CREATE IAM USER","BILLING","CREATE AND INSTANCE","DATABASES","HOME"};
rootUserDetails details;


    public SlidingDrawe() {
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
        View view= inflater.inflate(R.layout.fragment_sliding_drawe, container, false);
        lv=view.findViewById(R.id.listView);
        RootUserDashBoard activity= (RootUserDashBoard) getActivity();
        details=activity.getDetails();



        DrawerViewAdapter drawerViewAdapter=new DrawerViewAdapter((Activity) getContext(),array);
        lv.setAdapter(drawerViewAdapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if(position==0)
               {
                   final FragmentTransaction ft = getFragmentManager().beginTransaction();
                   CreateIamUser mMenuFragment ;

                       mMenuFragment = new CreateIamUser();
                   ft.replace(R.id.content, mMenuFragment, "NewFragmentTag");
                   ft.commit();


               }else if(position==1)
               {

               }else if(position==2){
                   Api api= ClientServer.getClientsever().create(Api.class);
                   HashMap<String,String> map=new HashMap<>();
                   map.put("token",details.getToken());
                   Call<List<String>> call=api.createANewInstance(map);
                   call.enqueue(new Callback<List<String>>() {
                       @Override
                       public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                           Toast.makeText(getContext(),"New Instances Created",Toast.LENGTH_LONG).show();
                       }

                       @Override
                       public void onFailure(Call<List<String>> call, Throwable t) {

                       }
                   });


               }else if(position==3){

               }else if(position==4){
                   IAMDetails mMenuFragment ;
                   final FragmentTransaction ft = getFragmentManager().beginTransaction();
                   mMenuFragment = new IAMDetails();
                   ft.replace(R.id.content, mMenuFragment, "NewFragmentTag");
                   ft.commit();

               }




            }
        });

        return view;
    }





}