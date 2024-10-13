package com.gharaana.ui.Screens


import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gharaana.R
import com.gharaana.ui.Elements.AutoSlidingCarousel
import com.google.accompanist.pager.ExperimentalPagerApi



@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    var searchText by remember { mutableStateOf("") }

    val images = listOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c,
        R.drawable.d,
        R.drawable.e,
    )
    
    Scaffold(modifier = Modifier.fillMaxSize())
    { padding->


        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top)
        {

            Spacer(modifier = Modifier.height(20.dp))

            // AUTO SCROLL CAROUSEL
            Card(
                modifier = Modifier.padding(16.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                AutoSlidingCarousel(
                    itemsCount = images.size,
                    itemContent = { index ->
                        Image(
                            painter = painterResource(id = images[index]),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.height(200.dp)
                        )
                    }
                )
            }

            // Gharaana Text
            Text(text = "GHARAANA",
                color = Color.Black,
                fontSize = 20.sp,
                letterSpacing = 10.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            // SEARCH BAR
            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(56.dp) // Height of the search box
                    .clip(RoundedCornerShape(8.dp)), // Rounded corners for the box
                placeholder = {
                    Text(text = "Search here...")
                },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = null)
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(180.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(colorResource(id = R.color.light_grey)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){

                Row(modifier = Modifier.fillMaxWidth(0.9f),
                    horizontalArrangement = Arrangement.Center){

                    Box(modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White)) {

                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Box(modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White)) {

                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Box(modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White)) {

                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Box(modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White)) {

                    }

                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(modifier = Modifier.fillMaxWidth(0.9f),
                    horizontalArrangement = Arrangement.Center){

                    Box(modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White)) {

                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Box(modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White)) {

                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Box(modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White)) {

                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Box(modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White)) {

                    }

                }


            }



        }

    }
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}
