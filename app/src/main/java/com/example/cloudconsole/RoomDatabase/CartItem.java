package com.example.cloudconsole.RoomDatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName="IAMUser")
public class CartItem {
//    private String title,desc,price,quantity,userId;
//    private String iwl;


      @NonNull
      @PrimaryKey
      public String id;
      public String rootUserID;
      public String IAMname;


    public CartItem(@NonNull String id, String rootUserID, String IAMname) {
        this.id = id;
        this.rootUserID = rootUserID;
        this.IAMname = IAMname;

    }


    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getRootUserID() {
        return rootUserID;
    }

    public void setRootUserID(String rootUserID) {
        this.rootUserID = rootUserID;
    }

    public String getIAMname() {
        return IAMname;
    }

    public void setIAMname(String IAMname) {
        this.IAMname = IAMname;
    }
}
