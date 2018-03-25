package com.example.asaadam.findfood.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asaadam.findfood.R;
import com.example.asaadam.findfood.models.Post;

/**
 * Created by jenrinaldo on 3/25/18.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder {

public TextView titleView;
public TextView authorView;
public ImageView starView;
public TextView numStarsView;
public TextView bodyView;

public MenuViewHolder(@NonNull View itemView) {
        super(itemView);

        titleView = itemView.findViewById(R.id.judul);
        authorView = itemView.findViewById(R.id.judul);
        starView = itemView.findViewById(R.id.time);
        numStarsView = itemView.findViewById(R.id.time);
        bodyView = itemView.findViewById(R.id.desc);
        }
        public void bindToPost(Post post, View.OnClickListener starClickListener) {
                titleView.setText(post.title);
                authorView.setText(post.author);
                numStarsView.setText(String.valueOf(post.starCount));
                bodyView.setText(post.body);

                starView.setOnClickListener(starClickListener);
        }
}