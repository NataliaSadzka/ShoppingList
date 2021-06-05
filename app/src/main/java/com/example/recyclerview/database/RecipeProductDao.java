package com.example.recyclerview.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecipeProductDao {
    @Query("SELECT * FROM RecipeProduct")
    List<RecipeProduct> getAllRecipeProducts();

    @Insert
    void insertRecipeProduct(RecipeProduct... recipeProducts);

    @Delete
    void delete(RecipeProduct recipeProduct);
}
