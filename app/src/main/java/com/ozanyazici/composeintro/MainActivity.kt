package com.ozanyazici.composeintro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ozanyazici.composeintro.ui.theme.ComposeIntroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setcontent parametre olarak bir composable metod istiyor
        //o yüzden mainScreen i burada veriyoruz.
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {

    //Column, Row, Box
    //Box bileşenleri z ekseni üstünde gösterir.
    //Yani üst üste bu özelliği bir resmin ütüne yazı yazmak gibi durumlarda kullanacağız.
    
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,) {

        CustomText(text = "Hello Android!")
        Spacer(modifier = Modifier.padding(0.dp,5.dp))
        CustomText(text = "Hello World!")
        Spacer(modifier = Modifier.padding(0.dp,5.dp))
        CustomText(text = "Hello Kotlin!")
        Spacer(modifier = Modifier.padding(0.dp,5.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {

            CustomText(text = "test 1")
            Spacer(modifier = Modifier.padding(5.dp,0.dp))
            CustomText(text = "test 2")
            Spacer(modifier = Modifier.padding(5.dp,0.dp))
            CustomText(text = "test 2")
        }
    }
}

//Diyelim ki ben tasarımını yaptığım bu text i birden fazla yerde kullanacağım.
//O zaman onu bir composable metod haline getirip kod tekrarını azaltırım.
@Composable
fun CustomText(text: String) {
    Text(
        //modifier ı yazarken sıralama önemli clickable ın önce yazılması daha doğru.
        modifier = Modifier
            .clickable {
                println("hello world")
            }
            .background(color = Color.Black)
            .padding(top = 10.dp, start = 1.dp, end = 1.dp, bottom = 20.dp)
            //.fillMaxSize(0.5f)
            //.width(150.dp)
        ,text = text,
        color = Color.White,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen()
}