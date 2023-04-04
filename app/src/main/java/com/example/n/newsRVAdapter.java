package com.example.n;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.n.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class newsRVAdapter extends RecyclerView.Adapter<newsRVAdapter.ViewHolder> {
    private ArrayList<Articles> articlesArrayList;
    private Context context;

    public newsRVAdapter(ArrayList<Articles> articlesArrayList, Context context) {
        this.articlesArrayList = articlesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public newsRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        return new newsRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull newsRVAdapter.ViewHolder holder, int position) {
        Articles articles=articlesArrayList.get(position);
        holder.subTitltTV.setText(articles.getDescription());
        holder.titleTV.setText(articles.getTitle());
        Picasso.get().load(articles.getUrlToImage()).into(holder.newsTV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, com.example.n.NewsdetailActivity.class);
                i.putExtra("title",articles.getTitle());
                i.putExtra("content",articles.getContent());
                i.putExtra("description",articles.getDescription());
                i.putExtra("image",articles.getUrlToImage());
                i.putExtra("url",articles.getUrl());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView   titleTV,subTitltTV;
        private ImageView newsTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV=itemView.findViewById(R.id.idTvHeading);
            subTitltTV=itemView.findViewById(R.id.idTvSubtitle);
            newsTV=itemView.findViewById(R.id.idIVNews);
        }
    }
}

