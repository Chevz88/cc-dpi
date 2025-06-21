package com.pekerja.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "aduan")
data class Aduan(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val judul: String,
    val isi: String,
    val timestamp: Long = System.currentTimeMillis()
)
