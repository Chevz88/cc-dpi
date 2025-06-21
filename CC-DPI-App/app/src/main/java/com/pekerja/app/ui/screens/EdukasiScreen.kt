package com.pekerja.app.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.pekerja.app.model.Berita
import com.pekerja.app.viewmodel.EdukasiViewModel

@Composable
fun EdukasiScreen(navController: NavController, viewModel: EdukasiViewModel = viewModel()) {
    val beritaList by viewModel.beritaList.collectAsState()
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Berita & Edukasi", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(beritaList) { berita ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                        .clickable {
                            berita.url?.let {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                                context.startActivity(intent)
                            }
                        },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(berita.judul, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(berita.deskripsi, style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Lihat Selengkapnya",
                            style = MaterialTheme.typography.labelLarge.copy(color = MaterialTheme.colorScheme.primary),
                            modifier = Modifier.clickable {
                                berita.url?.let {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                                    context.startActivity(intent)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
