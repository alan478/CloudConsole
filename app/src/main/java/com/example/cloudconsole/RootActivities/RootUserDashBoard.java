package com.example.cloudconsole.RootActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.example.cloudconsole.ClassForAPI.rootUserDetails;
import com.example.cloudconsole.IAMDetails;
import com.example.cloudconsole.R;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

public class RootUserDashBoard extends AppCompatActivity {

    FlowingDrawer mDrawer;
    public rootUserDetails details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_user_dash_board);

        details= (rootUserDetails) getIntent().getSerializableExtra("rootuserDetails");

        mDrawer = (FlowingDrawer) findViewById(R.id.drawerlayout);
        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
        mDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.OnDrawerStateChangeListener() {
            @Override
            public void onDrawerStateChange(int oldState, int newState) {
                if (newState == ElasticDrawer.STATE_CLOSED) {
                    Log.e("MainActivity", "Drawer STATE_CLOSED");
                }
            }

            @Override
            public void onDrawerSlide(float openRatio, int offsetPixels) {
                Log.e("MainActivity", "openRatio=" + openRatio + " ,offsetPixels=" + offsetPixels);
            }
        });

        setupMenu();
    }

    private void setupMenu() {
        FragmentManager fm = getSupportFragmentManager();
        SlidingDrawe mMenuFragment = (SlidingDrawe) fm.findFragmentById(R.id.id_container_menu);
        if (mMenuFragment == null) {
            mMenuFragment = new SlidingDrawe();
            fm.beginTransaction().add(R.id.id_container_menu, mMenuFragment).commit();
        }

        IAMDetails details=(IAMDetails) fm.findFragmentById(R.id.content);
        if(details==null)
        {
            details=new IAMDetails();
            fm.beginTransaction().add(R.id.content,details).commit();
        }


    }

    public rootUserDetails getDetails()
    {
        return details;
    }
}