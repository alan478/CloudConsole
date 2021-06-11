package com.example.cloudconsole;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cloudconsole.Adapters.IAMUserDisplay;
import com.example.cloudconsole.ClassForAPI.rootUserDetails;
import com.example.cloudconsole.RoomDatabase.AppDatabase;
import com.example.cloudconsole.RoomDatabase.CartDao;
import com.example.cloudconsole.RoomDatabase.CartItem;
import com.example.cloudconsole.RootActivities.RootUserDashBoard;

import java.util.List;


public class IAMDetails extends Fragment {
    RecyclerView rv;
rootUserDetails details;


    public IAMDetails() {
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
        View view= inflater.inflate(R.layout.fragment_i_a_m_details, container, false);
        AppDatabase db = Room.databaseBuilder(getContext(),
                AppDatabase.class, "IAM").allowMainThreadQueries().build();
        RootUserDashBoard activity= (RootUserDashBoard) getActivity();
        details=activity.getDetails();

        CartDao dao=db.cartDao();
        Log.e("IAMDETAILS","Activity");

       List<CartItem> list= dao.loadAllCartItem();

        rv=view.findViewById(R.id.rV);
        IAMUserDisplay display=new IAMUserDisplay(getContext(),list);
        rv.hasFixedSize();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(display);
        display.notifyDataSetChanged();




    return view;
    }
}