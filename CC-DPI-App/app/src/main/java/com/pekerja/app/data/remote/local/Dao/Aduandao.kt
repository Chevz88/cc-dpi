package com.pekerja.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pekerja.app.data.local.entity.Aduan
import kotlinx.coroutines.flow.Flow

@Dao
interface AduanDao {
    @Insert
    suspend fun insertAduan(aduan: Aduan)

    @Query("SELECT * FROM aduan ORDER BY timestamp DESC")
    fun getAllAduan(): Flow<List<Aduan>>
}
