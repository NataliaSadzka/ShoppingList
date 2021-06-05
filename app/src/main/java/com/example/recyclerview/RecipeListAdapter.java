package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerview.database.Recipe;

import java.util.List;

public class RecipeListAdapter  extends RecyclerView.Adapter<RecipeListAdapter.MyViewHolder> {

    private Context context;
    private List<Recipe> recipeList;

    public RecipeListAdapter(Context context) {
        this.context = context;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecipeListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recipes_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.MyViewHolder holder, final int position) {
        holder.textViewName.setText(this.recipeList.get(position).getName());
        /*holder.image_addNewRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = AppDatabase.getDbInstance(v.getContext());
                db.recipeDao().insertRecipe(recipeList.get(position));
            }
        });*/
        /*holder.image_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = AppDatabase.getDbInstance(v.getContext());
                db.recipeDao().delete(recipeList.get(position));
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return this.recipeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;

        public MyViewHolder(View view) {
            super(view);
            textViewName = view.findViewById(R.id.textViewName);

        }
    }
}
