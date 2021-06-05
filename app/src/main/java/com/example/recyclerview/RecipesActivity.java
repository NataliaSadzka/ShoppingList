package com.example.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerview.database.AppDatabase;
import com.example.recyclerview.database.Recipe;

import java.util.List;

public class RecipesActivity extends Activity {

    private RecipeListAdapter recipeListAdapter;

    private ImageView image_addNewRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_activity);

        image_addNewRecipe = findViewById(R.id.image_addNewRecipe);
        image_addNewRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(RecipesActivity.this, AddNewRecipeActivity.class), 100);
            }
        });
        initRecyclerView();
        loadRecipeList();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recipeListAdapter = new RecipeListAdapter(this);
        recyclerView.setAdapter(recipeListAdapter);
    }

    private void loadRecipeList() {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<Recipe> recipeList = db.recipeDao().getAllRecipes();
        recipeListAdapter.setRecipeList(recipeList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100) {
            loadRecipeList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
