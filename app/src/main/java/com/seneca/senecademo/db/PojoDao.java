package com.seneca.senecademo.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PojoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Pojo word);

    @Query("SELECT * FROM user_data")
    LiveData<List<Pojo>> getUserData();

}
