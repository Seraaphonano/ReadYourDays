package com.example.readyourdays.MemoryFragment;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.haibin.calendarview.Calendar;

@Entity
public class Diary {
    @PrimaryKey(autoGenerate = true)
    private String title;
    private Calendar calendar;
    private Calendar currenrDay;
    private Boolean isBefore;
    private String content;
}
