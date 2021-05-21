package com.example.recyclerview.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDAO {
    @Query("SELECT * FROM Product")
    List<Product>getAllUsers();

    @Insert
    void insertUser(Product... products);

    @Delete
    void delete(Product product);
}
