package com.example.cloudconsole.Adapters;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cloudconsole.R;

import java.util.List;

public class DrawerViewAdapter extends ArrayAdapter<String> {

    public Activity context;
    public String[] name;
    public DrawerViewAdapter(Activity context,String[] name)
    {
        super(context, R.layout.layout,name);
        this.context=context;
        this.name=name;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        convertView=inflater.inflate(R.layout.layout,null,true);

        TextView tv=convertView.findViewById(R.id.tv1);
        tv.setText(name[position]);

        //  imageView.setImageResource(imgid[position]);

        return convertView;


    }

}
