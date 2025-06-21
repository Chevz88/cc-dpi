@Composable
fun ChatbotScreen(navController: NavController) {
    var question by remember { mutableStateOf("") }
    var answer by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Chatbot Ketenagakerjaan", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = question,
            onValueChange = { question = it },
            label = { Text("Tulis pertanyaan") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (question.isNotBlank()) {
                    isLoading = true
                    coroutineScope.launch {
                        try {
                            val response = RetrofitClient.chatbotApi.getAnswer(question)
                            answer = response.answer
                        } catch (e: Exception) {
                            answer = "Gagal mengambil jawaban. Pastikan server aktif."
                        } finally {
                            isLoading = false
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kirim")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator()
        } else if (answer.isNotEmpty()) {
            Text("Bot: $answer", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
