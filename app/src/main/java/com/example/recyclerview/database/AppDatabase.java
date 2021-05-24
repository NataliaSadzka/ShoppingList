package com.example.recyclerview.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class, Recipe.class, ShoppingList.class, ProductRecipe.class, ProductShoppingList.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProductDAO productDAO();
    public abstract RecipeWithProductsDAO recipeWithProductsDAO();
    public abstract ShoppingListWithProductsDAO shoppingListWithProductsDAO();
    private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "BAZA")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

}
