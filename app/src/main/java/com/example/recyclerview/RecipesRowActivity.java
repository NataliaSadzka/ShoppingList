package com.example.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.example.recyclerview.database.AppDatabase;
import com.example.recyclerview.database.Recipe;

public class RecipesRowActivity extends Activity {

    /*private RecipeListAdapter recipeListAdapter;

    private ImageView image_addNewRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_row);

        image_addNewRecipe = findViewById(R.id.image_addNewRecipe);
        image_addNewRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(RecipesRowActivity.this, AddNewRecipeActivity.class));
            }
        });

    }
}

    /*private void saveNewRecipe(String name) {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        Recipe recipe = new Recipe();
        recipe.setName(name);

        db.recipeDao().insertRecipe(recipe);
        finish();
    }*/
}



