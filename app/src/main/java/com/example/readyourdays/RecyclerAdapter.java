package com.example.readyourdays;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readyourdays.MemoryFragment.Diary;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

   List<Diary> memories;
    public RecyclerAdapter(List<Diary> memories) {
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
        holder.title.setText(memories.get(position).getTitle());
        holder.daysLeft.setText(memories.get(position).getSelectedDay());
    }

    @Override
    public int getItemCount() {
        return memories.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public  TextView daysLeft;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           title = itemView.findViewById(R.id.card_title_memo);
            daysLeft = itemView.findViewById(R.id.card__days_countinng);

        }
    }
}
