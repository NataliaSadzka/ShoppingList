package com.example.recyclerview.database;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

@Database(entities = {Product.class, Recipe.class, ShoppingList.class, RecipeProduct.class, ShoppingListProduct.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProductDao productDao();
    public abstract RecipeDao recipeDao();
    public abstract RecipeProductDao recipeProductDao();
    public abstract RecipeWithProductsDAO recipeWithProductsDAO();
    public abstract ShoppingListWithProductsDAO shoppingListWithProductsDAO();
    private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "BAZA")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            Executors.newSingleThreadExecutor().execute(new Runnable() {
                                @Override
                                public void run() {
                                    INSTANCE.productDao().insertProduct(INSTANCE.products);
                                    INSTANCE.recipeDao().insertRecipe(INSTANCE.recipes);
                                    INSTANCE.recipeProductDao().insertRecipeProduct(INSTANCE.chiliConCarneRecipe);
                                }
                            });
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }

    Product[] products = new Product[] {
            new Product(1, "Mleko", "l"),
            new Product(2, "Cukier", "kg"),
            new Product(3, "M??ka", "kg"),
            new Product(4, "Mi??so mielone wo??owe", "kg"),
            new Product(5, "Pomidory w puszce", "szt"),
            new Product(6, "Fasola w puszce", "szt"),
            new Product(7, "Cebula", "kg"),
            new Product(8, "Czerwona papryka", "kg"),
            new Product(9, "??mietana 18%", "l")
    };

    Recipe[] recipes = new Recipe[] {
            new Recipe(1, "Chili con carne", null)
    };

    RecipeProduct[] chiliConCarneRecipe = new RecipeProduct[] {
            new RecipeProduct(1, 4, 0.4),
            new RecipeProduct(1, 5, 1),
            new RecipeProduct(1, 6, 1),
            new RecipeProduct(1, 7, 0.1),
            new RecipeProduct(1, 8, 0.1),
            new RecipeProduct(1, 9, 1)
    };
}