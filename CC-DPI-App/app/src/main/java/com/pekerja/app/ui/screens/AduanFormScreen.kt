@Composable
fun AduanFormScreen(navController: NavController) {
    var judul by remember { mutableStateOf("") }
    var isi by remember { mutableStateOf("") }
    var showSuccess by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Form Aduan", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = judul,
            onValueChange = { judul = it },
            label = { Text("Judul Aduan") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = isi,
            onValueChange = { isi = it },
            label = { Text("Isi Aduan") },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            maxLines = 6
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            if (judul.isNotBlank() && isi.isNotBlank()) {
                // Simpan ke DB/API (nanti)
                showSuccess = true
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Kirim Aduan")
        }

        if (showSuccess) {
            AlertDialog(
                onDismissRequest = {
                    showSuccess = false
                    navController.popBackStack()
                },
                title = { Text("Berhasil") },
                text = { Text("Aduan berhasil dikirim.") },
                confirmButton = {
                    TextButton(onClick = {
                        showSuccess = false
                        navController.popBackStack()
                    }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}
