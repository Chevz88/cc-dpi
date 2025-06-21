@Composable
fun SplashScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo", modifier = Modifier.size(120.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Text("Call Center Digital Pekerja Indonesia", style = MaterialTheme.typography.headlineSmall, color = Color.White)
        }
    }
    LaunchedEffect(true) {
        delay(2000)
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }
        }
    }
}
