package com.example.readyourdays;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.readyourdays.MemoryFragment.Diary;

import java.util.List;

@Dao
public interface DiaryDao {

    @Query("SELECT * FROM Diary")
    List<Diary> getAllDiaries();

    @Insert
    Void insertAl(Diary ... diaries);

    @Delete
    public void deleteUsers(Diary... diaries);
}

