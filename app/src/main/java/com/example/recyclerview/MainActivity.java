package com.example.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerview.database.AppDatabase;
import com.example.recyclerview.database.Product;

import java.util.List;

public class MainActivity extends Activity {

    private ProductListAdapter productListAdapter;
    private Button shoppingList;
    private Button recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);

        Button shoppingList = findViewById(R.id.shoppingList);
        Button recipes = findViewById(R.id.recipes);

        /*Button addNewProductButton = findViewById(R.id.addNewRecipeButton);
        addNewProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, AddNewRecipeActivity.class), 100);
            }
        });
        initRecyclerView();
        loadUserList();*/

        shoppingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNewProductActivity.class);
                startActivity(intent);
            }
        });

        recipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecipesActivity.class);
                startActivity(intent);
            }
        });
    }



    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        productListAdapter = new ProductListAdapter(this);
        recyclerView.setAdapter(productListAdapter);
    }

    private void loadUserList() {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<Product> productList = db.productDao().getAllProducts();
        productListAdapter.setProductList(productList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100) {
            loadUserList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}