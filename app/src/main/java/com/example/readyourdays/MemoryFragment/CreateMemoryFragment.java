package com.example.readyourdays.MemoryFragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.readyourdays.Base.BaseFragment;
import com.example.readyourdays.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateMemoryFragment extends BaseFragment implements View.OnClickListener{

    private ImageButton back_btn;
    private ImageButton save_top_btn;
    private Button save_bottom_btn;
    private Button select_date;
    private TextView title_memo;
    private Dialog popUpCalender;
    private BottomNavigationView navView;
    private Button memoSelectdate;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_memory, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        back_btn = view.findViewById(R.id.back_btn);
        save_top_btn = view.findViewById(R.id.save_top_btn);
        save_bottom_btn = view.findViewById(R.id.memo_save_bottom_btn);
        title_memo = view.findViewById(R.id.memo_title);
        popUpCalender = new Dialog(getContext());
        save_bottom_btn = view.findViewById(R.id.pop_select_date);
        navView =  view.findViewById(R.id.bottom_Navigation);
      memoSelectdate = view.findViewById(R.id.memo_select_date);
        memoSelectdate.setOnClickListener(this);

    }

    private void iniVariable(View view) {

    }

    private void iniPopWindows(View view){
        Button pop_ok;
        popUpCalender.setContentView(R.layout.pop_up_calendarview);
        pop_ok = popUpCalender.findViewById(R.id.pop_select_date);

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.memo_select_date:
                iniPopWindows(v);
        }

    }
}
