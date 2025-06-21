@Composable
fun DashboardScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Selamat Datang di Call Center Digital Pekerja Indonesia",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )

        LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(16.dp)) {
            items(listOf(
                "Form Aduan" to "aduan",
                "Riwayat" to "riwayat",
                "Edukasi" to "edukasi",
                "Chatbot" to "chatbot",
                "Profil" to "profil",
                "Tentang" to "tentang"
            )) { (label, route) ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable { navController.navigate(route) },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = label, textAlign = TextAlign.Center)
                    }
                }
            }
        }
    }
}
