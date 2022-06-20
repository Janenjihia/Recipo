package com.moringaschool.recipo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.recipo.R;
import com.moringaschool.recipo.models.Categories;
import com.moringaschool.recipo.ui.CategoryActivity;
import com.moringaschool.recipo.ui.CategoryPresenter;
import com.moringaschool.recipo.ui.LoginActivity;
import com.moringaschool.recipo.ui.SignupActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHomeAdapter extends RecyclerView.Adapter<RecyclerViewHomeAdapter.RecyclerViewHolder> {
    private List<Categories.Category> categories;
    private Context context;
    private static ClickListener clickListener;

    public RecyclerViewHomeAdapter(List<Categories.Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_category,
                viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder viewHolder, int i) {

        String strCategoryThum = categories.get(i).getStrCategoryThumb();
        Picasso.get().load(strCategoryThum).placeholder(R.drawable.ic_circle).into(viewHolder.categoryThumb);

        String strCategoryName = categories.get(i).getStrCategory();
        viewHolder.categoryName.setText(strCategoryName);



//        viewHolder.categoryName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context,strCategoryName,Toast.LENGTH_LONG).show();
////                new Intent(context, CategoryActivity.class);
//
//            }});
    }


    @Override
    public int getItemCount() {
        return categories.size();
    }


    static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.categoryThumb)
        ImageView categoryThumb;
        @BindView(R.id.categoryName)
        TextView categoryName;

        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAbsoluteAdapterPosition());
        }
    }


    public void setOnItemClickListener(ClickListener clickListener) {
        RecyclerViewHomeAdapter.clickListener = clickListener;
    }


    public interface ClickListener {
        void onClick(View view, int position);
    }
}