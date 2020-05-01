package com.example.readyourdays;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.readyourdays.R;
import  com.example.readyourdays.FirstFragment;
import com.example.readyourdays.SecondFragment;
import com.example.readyourdays.ThirdFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Field;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView navView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navView =  findViewById(R.id.bottom_Navigation);


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);


        NavigationUI.setupWithNavController(navView, navController);
    }

    }



