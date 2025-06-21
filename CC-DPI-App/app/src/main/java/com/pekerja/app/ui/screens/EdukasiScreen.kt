package com.pekerja.app.ui.screens

import androidx.compose.foundation.layout.* import androidx.compose.foundation.lazy.LazyColumn import androidx.compose.foundation.lazy.items import androidx.compose.material3.* import androidx.compose.runtime.* import androidx.compose.ui.Modifier import androidx.compose.ui.unit.dp import androidx.lifecycle.viewmodel.compose.viewModel import com.pekerja.app.model.Berita import com.pekerja.app.viewmodel.EdukasiViewModel

@Composable fun EdukasiScreen(navController: NavController, viewModel: EdukasiViewModel = viewModel()) { val beritaList by viewModel.beritaList.collectAsState()

Column(modifier = Modifier.padding(16.dp)) {
    Text("Berita & Edukasi", style = MaterialTheme.typography.headlineSmall)
    Spacer(modifier = Modifier.height(16.dp))

    LazyColumn {
        items(beritaList) { berita ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(berita.judul, style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(berita.deskripsi, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    TextButton(onClick = { /* TODO: open URL or detail */ }) {
                        Text("Lihat Selengkapnya")
                    }
                }
            }
        }
    }
}

}

