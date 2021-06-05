package com.example.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.example.recyclerview.database.AppDatabase;
import com.example.recyclerview.database.Recipe;

public class AddNewRecipeActivity extends Activity {

    //private ImageView image_addNewRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_row);

        final EditText nameInput = findViewById(R.id.nameInput);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewRecipe(nameInput.getText().toString());

            }
        });
    }

    private void saveNewRecipe(String name) {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        Recipe recipe = new Recipe();
        recipe.setName(name);

        db.recipeDao().insertRecipe(recipe);
        finish();
    }
}
