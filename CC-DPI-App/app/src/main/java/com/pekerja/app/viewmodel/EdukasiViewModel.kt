package com.pekerja.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pekerja.app.model.Berita
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EdukasiViewModel : ViewModel() {

    private val _beritaList = MutableStateFlow<List<Berita>>(emptyList())
    val beritaList: StateFlow<List<Berita>> = _beritaList

    init {
        loadBeritaDummy()
    }

    private fun loadBeritaDummy() {
        viewModelScope.launch {
            _beritaList.value = listOf(
                Berita("UMR 2025 Akan Naik?", "Kemnaker bahas formula baru kenaikan UMR."),
                Berita("BPJS Ketenagakerjaan Digital", "Transformasi layanan BPJS secara online mulai diberlakukan."),
                Berita("Cuti Sakit & Hak Buruh", "Apa saja hak buruh saat sakit berdasarkan UU?")
            )
        }
    }
}
