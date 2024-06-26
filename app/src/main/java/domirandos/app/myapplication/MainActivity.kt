package domirandos.app.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import domirandos.app.myapplication.navigation.Screens
import domirandos.app.myapplication.screens.home.HomeModel
import domirandos.app.myapplication.screens.home.HomeView
import domirandos.app.myapplication.screens.home.HomeViewModel
import domirandos.app.myapplication.networking.APIClient
import domirandos.app.myapplication.networking.APIService
import domirandos.app.myapplication.screens.details.DetailsModel
import domirandos.app.myapplication.screens.details.DetailsView
import domirandos.app.myapplication.screens.details.DetailsViewModel
import domirandos.app.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


            val api = APIClient.getInstance().create(APIService::class.java)




                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screens.HomeView.route){

                        composable(route = Screens.HomeView.route) {
                            val homeModel = HomeModel(api)
                            val homeViewModel = HomeViewModel(homeModel)
                            HomeView(viewModel = homeViewModel,navController = navController)
                        }
                        composable(route = Screens.DetailsView.route, arguments = listOf(navArgument("id") {
                            type = NavType.IntType
                        })) {
                            val id = it.arguments?.getInt("id")!!
                            val detailsModel = DetailsModel(api)
                            val detailViewModel = DetailsViewModel(detailsModel, id)
                            DetailsView(viewModel = detailViewModel,id,navController = navController)
                        }
                    }








                }
            }
        }
    }
}
