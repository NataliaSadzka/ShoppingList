package com.example.recyclerview.database;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface RecipeWithProductsDAO {
    @Transaction
    @Query("SELECT * FROM Recipe")
    List<RecipeWithProducts> getRecipeWithProducts();
}
