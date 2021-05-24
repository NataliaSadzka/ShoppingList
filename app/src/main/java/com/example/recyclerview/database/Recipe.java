package com.example.recyclerview.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Recipe {

    @PrimaryKey(autoGenerate = true)
    private int recipeId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "photo")
    private byte[] photo;

    public int getRecipeId() {
        return recipeId;
    }

    public String getName() {
        return name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
