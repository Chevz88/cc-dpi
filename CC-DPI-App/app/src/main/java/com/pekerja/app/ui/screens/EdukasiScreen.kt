@Composable
fun EdukasiScreen(navController: NavController) {
    val beritaList = listOf(
        Berita("UMR 2025 Akan Naik?", "Kemnaker bahas formula baru kenaikan UMR."),
        Berita("BPJS Ketenagakerjaan Digital", "Transformasi layanan BPJS secara online mulai diberlakukan."),
        Berita("Cuti Sakit & Hak Buruh", "Apa saja hak buruh saat sakit berdasarkan UU?")
    )

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
                        TextButton(onClick = { /* TODO: open URL */ }) {
                            Text("Lihat Selengkapnya")
                        }
                    }
                }
            }
        }
    }
