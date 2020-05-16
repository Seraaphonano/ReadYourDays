package com.example.readyourdays.MemoryFragment;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.haibin.calendarview.Calendar;

@Entity(indices = {@Index(value = {"title", "date"},
        unique = true)})
public class Diary {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "date")
    private int selectedDay;
    @ColumnInfo(name = "isMemory")
    private Boolean isMemory;
    @ColumnInfo(name = "content")
    private String content;

    public Diary(String title, int selectedDay, Boolean isMemory, String content) {
        this.title = title;
        this.selectedDay = selectedDay;
        this.isMemory = isMemory;
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getSelectedDay() {
        return selectedDay;
    }

    public Boolean getMemory() {
        return isMemory;
    }

    public String getContent() {
        return content;
    }

    //private Calendar currenrDay;
}
