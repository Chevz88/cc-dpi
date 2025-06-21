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
                Berita(
                    "UMR 2025 Akan Naik?",
                    "Kemnaker bahas formula baru kenaikan UMR.",
                    "https://www.kemnaker.go.id"
                ),
                Berita(
                    "BPJS Ketenagakerjaan Digital",
                    "Transformasi layanan BPJS secara online mulai diberlakukan.",
                    "https://www.bpjsketenagakerjaan.go.id"
                ),
                Berita(
                    "Cuti Sakit & Hak Buruh",
                    "Apa saja hak buruh saat sakit berdasarkan UU?",
                    "https://peraturan.bpk.go.id/Home/Details/39169/uu-no-13-tahun-2003"
                )
            )
        }
    }
}
