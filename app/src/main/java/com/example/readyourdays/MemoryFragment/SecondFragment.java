package com.example.readyourdays.MemoryFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.readyourdays.Base.BaseFragment;
import com.example.readyourdays.DiaryDatabase;
import com.example.readyourdays.HomeFragment.FirstFragment;
import com.example.readyourdays.R;
import com.example.readyourdays.RecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends BaseFragment implements View.OnClickListener {

    private RecyclerView displayMomery;
    private RecyclerView.Adapter adapter;
    private FloatingActionButton addNewMemo;
    private Context mcontext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        mcontext = context;

    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        iniComponents(view);

        return view;
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {

    }


    private void iniComponents(View view) {

        addNewMemo = view.findViewById(R.id.add_mem_btn);
        displayMomery = view.findViewById(R.id.memo_receyclerview);

        DiaryDatabase db = Room.databaseBuilder(mcontext.getApplicationContext(), DiaryDatabase.class, "Production")
                .allowMainThreadQueries()
                .build();

        List<Diary> Memories = db.diaryDao().getAllDiaries();
        displayMomery.setLayoutManager(new LinearLayoutManager(mcontext));
        adapter = new RecyclerAdapter(Memories);
        displayMomery.setAdapter(adapter);


        addNewMemo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_mem_btn:
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_navigation_memory_to_createMemoryFragment);
        }
    }
}
