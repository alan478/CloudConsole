package com.example.cloudconsole.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CartDao {

    @Insert
    public void insertCartItem(CartItem cartItem);

    @Query("SELECT * FROM IAMUser")
    public List<CartItem> loadAllCartItem();




}
