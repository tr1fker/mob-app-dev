//-----------------------------1


//package com.example.helloapp
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            Main()
//        }
//    }
//}
//
//@Composable
//fun Main() {
//    val navController = rememberNavController()
//    Column(Modifier.padding(8.dp)) {
//        NavBar(navController = navController)
//        NavHost(navController, startDestination = NavRoutes.Home.route) {
//            composable(NavRoutes.Home.route) { Home() }
//            composable(NavRoutes.Contacts.route) { Contacts()  }
//            composable(NavRoutes.About.route) { About() }
//        }
//    }
//}
//@Composable
//fun NavBar(navController: NavController){
//    Row(
//        Modifier.fillMaxWidth().padding(bottom = 8.dp)){
//        Text("Home",
//            Modifier
//                .weight(0.33f)
//                .clickable { navController.navigate(NavRoutes.Home.route) },
//            fontSize = 22.sp, color= Color(0xFF6650a4))
//        Text("Contacts",
//            Modifier
//                .weight(0.33f)
//                .clickable { navController.navigate(NavRoutes.Contacts.route) },
//            fontSize = 22.sp, color= Color(0xFF6650a4))
//        Text("About",
//            Modifier
//                .weight(0.33f)
//                .clickable { navController.navigate(NavRoutes.About.route) },
//            fontSize = 22.sp, color= Color(0xFF6650a4))
//    }
//}
//@Composable
//fun Home(){
//    Text("Home Page", fontSize = 30.sp)
//}
//@Composable
//fun Contacts(){
//    Text("Contact Page", fontSize = 30.sp)
//}
//@Composable
//fun About(){
//    Text("About Page", fontSize = 30.sp)
//}
//sealed class NavRoutes(val route: String) {
//    object Home : NavRoutes("home")
//    object Contacts : NavRoutes("contact")
//    object About : NavRoutes("about")
//}


//-----------------------------2

//package com.example.helloapp
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.navArgument
//
//
//class MainActivity : ComponentActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            Main()
//        }
//    }
//}
//
//sealed class UserRoutes(val route: String) {
//    object Users : UserRoutes("users")
//    object User : UserRoutes("user")
//}
//@Composable
//fun Main() {
//    val navController = rememberNavController()
//    val employees = listOf(
//        Employee(1, "Tom", 39),
//        Employee(2, "Bob", 43),
//        Employee(3, "Sam", 28)
//    )
//    NavHost(navController, startDestination = UserRoutes.Users.route) {
//        composable(UserRoutes.Users.route) { Users(employees, navController) }
//        composable(UserRoutes.User.route + "/{userId}",
//            arguments = listOf(navArgument("userId") { type = NavType.IntType }))
//        {
//                stackEntry ->
//            val userId = stackEntry.arguments?.getInt("userId")
//            User(userId, employees)
//        }
//    }
//}
//@Composable
//fun Users(data: List<Employee>, navController: NavController){
//    LazyColumn {
//        items(data){
//                u->
//            Row(Modifier.fillMaxWidth()){
//                Text(u.name,
//                    Modifier.padding(8.dp).clickable {
//                        navController.navigate("user/${u.id}") },
//                    fontSize = 28.sp)
//            }
//        }
//    }
//}
//@Composable
//fun User(userId:Int?, data: List<Employee>){
//    val user = data.find { it.id==userId }
//    if(user!=null) {
//        Column {
//            Text("Id: ${user.id}", Modifier.padding(8.dp), fontSize = 22.sp)
//            Text("Name: ${user.name}", Modifier.padding(8.dp), fontSize = 22.sp)
//            Text("Age: ${user.age}", Modifier.padding(8.dp), fontSize = 22.sp)
//        }
//    }
//    else{
//        Text("User Not Found")
//    }
//}
//
//data class Employee(val id:Int, val name:String, val age:Int)


//-----------------------------3


package com.example.helloapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }
}
@Composable
fun Main() {
    val navController = rememberNavController()
    Column(Modifier.padding(8.dp)) {
        NavHost(navController, startDestination = NavRoutes.Home.route, modifier
        = Modifier.weight(1f)) {
            composable(NavRoutes.Home.route) { Home() }
            composable(NavRoutes.Contacts.route) { Contacts()  }
            composable(NavRoutes.About.route) { About() }
        }
        BottomNavigationBar(navController = navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.BarItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        {saveState = true}
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = navItem.image,
                        contentDescription = navItem.title)
                },
                label = {
                    Text(text = navItem.title)
                }

            )
        }
    }
}

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "home"
        ),
        BarItem(
            title = "Contacts",
            image = Icons.Filled.Face,
            route = "contacts"
        ),
        BarItem(
            title = "About",
            image = Icons.Filled.Info,
            route = "about"
        )
    )
}

data class BarItem(
    val title: String,
    val image: ImageVector,
    val route: String
)

@Composable
fun Home(){
    Text("Home Page", fontSize = 30.sp)
}
@Composable
fun Contacts(){
    Text("Contact Page", fontSize = 30.sp)
}
@Composable
fun About(){
    Text("About Page", fontSize = 30.sp)
}

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Contacts : NavRoutes("contacts")
    object About : NavRoutes("about")
}