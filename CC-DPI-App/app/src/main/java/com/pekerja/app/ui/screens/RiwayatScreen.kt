package com.pekerja.app.ui.screens

import androidx.compose.foundation.layout.* import androidx.compose.foundation.lazy.LazyColumn import androidx.compose.foundation.lazy.items import androidx.compose.material3.* import androidx.compose.runtime.* import androidx.compose.ui.Modifier import androidx.compose.ui.unit.dp import androidx.lifecycle.viewmodel.compose.viewModel import com.pekerja.app.viewmodel.AduanViewModel import java.text.SimpleDateFormat import java.util.*

@Composable fun RiwayatScreen(navController: NavController, viewModel: AduanViewModel = viewModel()) { val aduanList by viewModel.allAduan.collectAsState(initial = emptyList())

Column(modifier = Modifier.padding(16.dp)) {
    Text("Riwayat Aduan", style = MaterialTheme.typography.headlineSmall)
    Spacer(modifier = Modifier.height(16.dp))

    if (aduanList.isEmpty()) {
        Text("Belum ada aduan.", style = MaterialTheme.typography.bodyLarge)
    } else {
        LazyColumn {
            items(aduanList) { aduan ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(aduan.judul, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(aduan.isi, style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = formatDate(aduan.timestamp),
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
            }
        }
    }
}

}

fun formatDate(timestamp: Long): String { val sdf = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault()) return sdf.format(Date(timestamp)) }

