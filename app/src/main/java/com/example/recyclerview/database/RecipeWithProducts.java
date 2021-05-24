package com.example.recyclerview.database;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class RecipeWithProducts {
    @Embedded
    public Recipe recipes;
    @Relation(
            parentColumn = "recipeId",
            entityColumn = "productId",
            associateBy = @Junction(ProductRecipe.class)
    )
    public List<Product> products;
}
