package com.example.expensetrackerapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.expensetrackerapp.Model.Category;
import com.example.expensetrackerapp.R;

import java.util.ArrayList;

public class CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.ViewHolder> {
    // variable for our array list and context
    private ArrayList<Category> CategoryModalArrayList;
    private Context context;

    // constructor
    public CategoryRVAdapter(ArrayList<Category> CategoryModalArrayList, Context context) {
        this.CategoryModalArrayList = CategoryModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category modal = CategoryModalArrayList.get(position);

//        Toast.makeText(this.context, "obj:" + modal.getName(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this.context, "obj:" + modal.getCost(), Toast.LENGTH_SHORT).show();
        holder.categoryName.setText(modal.getName());
        String cost = String.valueOf(modal.getCost());  // convert int cost to string
        holder.categegoryCost.setText(cost);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are calling an intent.
                TextView categoryName = v.findViewById(R.id.Categoryname);
                Toast.makeText(context, categoryName.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return CategoryModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        TextView categoryName, categegoryCost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            categoryName = itemView.findViewById(R.id.Categoryname);
            categegoryCost = itemView.findViewById(R.id.CategoryCost);
        }
    }
}
