package com.example.cloudconsole.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cloudconsole.R;
import com.example.cloudconsole.RoomDatabase.CartItem;

import java.util.List;

public class IAMUserDisplay extends RecyclerView.Adapter<IAMUserDisplay.Serviceviewholder> {

    private Context mct;
    private List<CartItem> list;



    public IAMUserDisplay(Context mct,List<CartItem> list) {
        this.mct = mct;
        this.list = list;
    }

    @Override
    public Serviceviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mct);
        View view = inflater.inflate(R.layout.order_details_vendor_side,null);
        return new Serviceviewholder(view);
    }

    @Override
    public void onBindViewHolder(final Serviceviewholder holder, int position) {
        final CartItem classes=list.get(position);
        holder.tv1.setText(classes.getIAMname());
        holder.twDesc.setText(classes.getRootUserID());


















    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Serviceviewholder extends RecyclerView.ViewHolder{

        TextView tv1,twDesc,tvMisc;
        ImageView iw1;





        public Serviceviewholder(View itemView) {
            super(itemView);

            tv1=itemView.findViewById(R.id.tv1);
            twDesc=itemView.findViewById(R.id.twDesc);
            tvMisc=itemView.findViewById(R.id.tvMisc);
            iw1=itemView.findViewById(R.id.iw1);









        }



    }


}

