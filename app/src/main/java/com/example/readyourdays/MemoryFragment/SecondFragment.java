package com.example.readyourdays.MemoryFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;

import com.example.readyourdays.Base.BaseFragment;
import com.example.readyourdays.HomeFragment.FirstFragment;
import com.example.readyourdays.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SecondFragment extends BaseFragment implements View.OnClickListener {

    private FloatingActionButton addNewMemo;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        iniComponents(view);

    }

    private void iniComponents(View view) {
        addNewMemo = view.findViewById(R.id.add_mem_btn);



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
