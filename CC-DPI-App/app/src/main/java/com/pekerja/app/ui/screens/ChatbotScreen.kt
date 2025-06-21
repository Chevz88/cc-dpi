@Composable
fun ChatbotScreen(navController: NavController) {
    var input by remember { mutableStateOf("") }
    val conversation = remember { mutableStateListOf("Halo! Saya bot edukasi ketenagakerjaan. Apa yang ingin kamu ketahui?") }

    val jawabanBot: Map<String, String> = mapOf(
        "upah" to "Upah minimum ditentukan berdasarkan wilayah dan sektor.",
        "lembur" to "Pekerja berhak atas uang lembur jika bekerja melebihi jam kerja normal.",
        "phk" to "PHK harus disertai alasan sah dan pesangon sesuai UU Ketenagakerjaan.",
        "cuti" to "Pekerja tetap berhak atas cuti tahunan minimal 12 hari kerja."
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Chat Edukasi", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(conversation) { msg ->
                Text("• $msg", modifier = Modifier.padding(vertical = 4.dp))
            }
        }

        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Tanya sesuatu...") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            if (input.isNotBlank()) {
                conversation.add("Kamu: $input")
                val jawaban = jawabanBot.entries.find { input.contains(it.key, ignoreCase = true) }?.value
                    ?: "Maaf, saya belum punya jawaban untuk pertanyaan itu."
                conversation.add("Bot: $jawaban")
                input = ""
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Kirim")
        }
    }
}
