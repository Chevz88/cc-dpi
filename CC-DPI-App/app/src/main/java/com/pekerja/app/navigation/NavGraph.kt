@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("dashboard") { DashboardScreen(navController) }
        composable("aduan") { AduanFormScreen(navController) }
        composable("riwayat") { RiwayatScreen(navController) }
        composable("edukasi") { EdukasiScreen(navController) }
        composable("chatbot") { ChatbotScreen(navController) }
        composable("profil") { ProfilScreen(navController) }
        composable("info") { InfoPekerjaScreen(navController) }
        composable("tentang") { TentangScreen(navController) }
    }
}
