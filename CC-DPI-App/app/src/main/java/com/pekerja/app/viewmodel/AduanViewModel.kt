package com.pekerja.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.pekerja.app.data.local.AppDatabase
import com.pekerja.app.data.local.entity.Aduan
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AduanViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "ccdpi.db"
    ).build()

    private val aduanDao = db.aduanDao()

    val allAduan: Flow<List<Aduan>> = aduanDao.getAllAduan()

    fun kirimAduan(judul: String, isi: String) {
        viewModelScope.launch {
            val aduan = Aduan(judul = judul, isi = isi)
            aduanDao.insertAduan(aduan)
        }
    }
}
