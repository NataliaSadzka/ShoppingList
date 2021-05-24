package com.example.recyclerview.database;

import androidx.room.Entity;

@Entity(primaryKeys = {"productId", "shoppingListId"})
public class ProductShoppingList {

    private long productId;
    private long shoppingListId;
    private int quantity;
    private boolean added;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(long shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAdded() {
        return added;
    }
}
