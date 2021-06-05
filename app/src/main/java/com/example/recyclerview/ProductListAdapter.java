package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerview.database.AppDatabase;
import com.example.recyclerview.database.Product;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {

    private Context context;
    private List<Product> productList;

    public ProductListAdapter(Context context) {
        this.context = context;
    }


    public void setProductList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.MyViewHolder holder, final int position) {
        holder.tvName.setText(this.productList.get(position).getName());
        holder.tvQuantity.setText(this.productList.get(position).getQuantityUnit());
        holder.image_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = AppDatabase.getDbInstance(v.getContext());
                db.productDao().delete(productList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvQuantity;
        ImageView image_delete;

        public MyViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tvName);
            tvQuantity = view.findViewById(R.id.tvQuantity);
            image_delete = view.findViewById(R.id.image_delete);
        }
    }

}
