package com.example.readyourdays;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.readyourdays.MemoryFragment.Diary;

@Database(entities = {Diary.class}, version = 1)
public abstract class DiaryDatabase extends RoomDatabase {
    public abstract DiaryDao diaryDao();
}
