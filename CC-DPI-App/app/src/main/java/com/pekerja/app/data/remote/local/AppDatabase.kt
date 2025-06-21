package com.pekerja.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pekerja.app.data.local.dao.AduanDao
import com.pekerja.app.data.local.entity.Aduan

@Database(entities = [Aduan::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun aduanDao(): AduanDao
}
