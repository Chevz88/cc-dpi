@Composable
fun AduanFormScreen(navController: NavController, viewModel: AduanViewModel = viewModel()) {
    var judul by remember { mutableStateOf("") }
    var isi by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Formulir Aduan", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = judul,
            onValueChange = { judul = it },
            label = { Text("Judul Aduan") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = isi,
            onValueChange = { isi = it },
            label = { Text("Isi Aduan") },
            modifier = Modifier.fillMaxWidth().height(150.dp),
            maxLines = 10
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.kirimAduan(judul, isi)
                Toast.makeText(context, "Aduan terkirim!", Toast.LENGTH_SHORT).show()
                judul = ""
                isi = ""
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kirim Aduan")
        }
    }
}
