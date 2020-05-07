package com.example.readyourdays;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

   ArrayList<String> memories;
    public RecyclerAdapter(ArrayList<String> memories) {
        this.memories = memories;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.memo_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.title.setText(memories.get(position));
    }

    @Override
    public int getItemCount() {
        return memories.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           title = itemView.findViewById(R.id.card_title_memo);
           // itemView.findViewById(R.id.card__days_countinng);

        }
    }
}
