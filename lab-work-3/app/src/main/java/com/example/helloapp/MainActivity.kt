//-----------------------vertical list

//package com.example.helloapp
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.ui.Modifier
//import androidx.compose.material3.Text
//import androidx.compose.ui.unit.sp
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            val langs = listOf("Kotlin", "Java", "JavaScript", "Python", "C#", "C++",
//                "Rust")
////            LazyColumn(
////                Modifier.fillMaxSize()
////            ){
////                item { Text("Языки программирования", fontSize = 29.sp) }
////                items(langs){lang -> Text(lang, fontSize = 24.sp)}
////            }
//            LazyColumn(
//                modifier = Modifier.fillMaxSize(),
//                contentPadding = PaddingValues(5.dp)
//            ){
//                item { Text("Языки программирования", fontSize = 29.sp) }
//                itemsIndexed(langs){index,lang -> Text(lang, fontSize = 23.sp,
//                    modifier=Modifier.background(
//                        if(index%2==0) Color(0xffdddddd) else Color.Transparent
//                    ).padding(8.dp).fillMaxWidth())}
//            }
//        }
//    }
//}


//--------------------------horizontal list



//package com.example.helloapp
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Text
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            val langs = listOf(
//                Language("Kotlin", 0xff16a085),
//                Language("Java", 0xff2980b9),
//                Language("JavaScript", 0xffd35400),
//                Language("Python", 0xff2c3e50)
//            )
//            LazyRow {
//                items(langs) { lang ->
//                    Column(
//                        Modifier.padding(8.dp),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Box(Modifier.size(100.dp).background(Color(lang.hexColor)))
//                        Text(lang.name, fontSize = 24.sp, modifier =
//                            Modifier.padding(8.dp))
//                    }
//                }
//            }
//        }
//    }
//}
//data class Language(val name:String, val hexColor: Long)


//--------------------------click tp to the end

//package com.example.helloapp
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.padding
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.material3.Text
//import androidx.compose.ui.unit.sp
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.foundation.lazy.rememberLazyListState
//import androidx.compose.foundation.lazy.LazyColumn
//import kotlinx.coroutines.launch
//import androidx.compose.foundation.clickable
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent{
//            val listState = rememberLazyListState()
//            val coroutineScope = rememberCoroutineScope()
//            LazyColumn(state=listState) {
//                item{Text("В конец",
//                    Modifier.padding(8.dp).background(Color.DarkGray).padding(5.dp).clickable {
//                        coroutineScope.launch() {
//                            listState.animateScrollToItem(19)
//                        }
//                    }, fontSize = 28.sp, color = Color.White)
//                }
//                items(20){
//                    Text("Item $it", Modifier.padding(8.dp), fontSize = 28.sp)
//                }
//            }
//        }
//    }
//}

//--------------smartphones with grouping

package com.example.helloapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
////ex-1
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent @OptIn(ExperimentalFoundationApi::class){
//// начальные данные
//            val phones = listOf("Apple iPhone 15 Pro", "Realme 11 PRO",
//                "Google Pixel 5", "Samsung Galaxy S24 Ultra", "Google Pixel 6",
//                "Samsung Galaxy S21 FE", "Apple iPhone 15 Pro Max", "Xioami Redmi Note 12", "Xiaomi Redmi 12",
//                "Apple iPhone 13", "Google Pixel 6", "Apple iPhone 14",
//                "Realme C30s", "Realme Note 50")
//// создаем группы
//            val groups = phones.groupBy { it.substringBefore(" ") }
//            LazyColumn(
//                contentPadding = PaddingValues(5.dp)
//            ){
//                groups.forEach { (brand, models) ->
//                    stickyHeader {
//                        Text(
//                            text = brand,
//                            fontSize = 28.sp,
//                            color = Color.White,
//                            modifier =
//                                Modifier.background(Color.Gray).padding(5.dp).fillMaxWidth()
//                        )
//                    }
//                    items(models) { model ->
//                        Text(model, Modifier.padding(5.dp), fontSize = 28.sp)
//                    }
//                }
//            }
//        }
//    }
//}
//ex-2
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent @OptIn(ExperimentalFoundationApi::class){
//            val people = listOf(
//                Person("Tom", "Microsoft"), Person("Alice", "Microsoft"),
//                Person("Bob", "Google"), Person("Sam", "JetBrains"),
//                Person("Kate", "Google"), Person("Mark", "Google"),
//                Person("Bill", "Microsoft"), Person("Sandra", "JetBrains"),
//                Person("Lisa", "Apple"), Person("Alex", "Apple")
//            )
//            val groups = people.groupBy { it.company }
//            LazyColumn(
//                contentPadding = PaddingValues(5.dp)
//            ){
//                groups.forEach { (company, employees) ->
//                    stickyHeader {
//                        Text(
//                            text = company,
//                            fontSize = 28.sp,
//                            color = Color.White,
//                            modifier =
//                                Modifier.background(Color.Gray).padding(5.dp).fillMaxWidth()
//                        )
//                    }
//                    items(employees) { employee ->
//                        Text(employee.name, Modifier.padding(5.dp), fontSize =
//                            28.sp)
//                    }
//                }
//            }
//        }
        ////anim
        setContent {
            val startOffset = 0
            val endOffset = 300
            val boxWidth = 150
            var boxState by remember { mutableStateOf(startOffset)}
            val offset by animateDpAsState(targetValue = boxState.dp)
            Column(Modifier.fillMaxWidth()) {
                Box(Modifier.padding(start=offset)
                    .size(boxWidth.dp)
                    .background(Color.DarkGray))
                Button({boxState = if (boxState==startOffset){endOffset} else {startOffset}},
                    Modifier.padding(10.dp)) {
                }
            }
                    Text("Move", fontSize = 25.sp)
        }
    }
}
data class Person(val name:String, val company: String)