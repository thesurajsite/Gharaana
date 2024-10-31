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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gharaana.R
import com.gharaana.presentation.components.AutoSlidingCarousel
import com.google.accompanist.pager.ExperimentalPagerApi



@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    var searchText by remember { mutableStateOf("") }

    // State to hold the scroll position
    val listState = rememberLazyListState()
    // List of items to display in cards
    val items = List(10) { "Card #${it + 1}" } // Example list of 10 items

    val imagesCarousel1 = listOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c,
        R.drawable.d,
        R.drawable.e,
    )

    val imagesCarousel2 = listOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c,
        R.drawable.d,
        R.drawable.e,
    )

    val frequentlyUsedServices = listOf(
        R.drawable.cosmetic1,
        R.drawable.cosmetic2,
        R.drawable.cosmetic3,
        R.drawable.cosmetic1,
        R.drawable.cosmetic2,
        R.drawable.cosmetic3

    )

    Scaffold(modifier = Modifier.fillMaxSize())
    { padding ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        )
        {

            Spacer(modifier = Modifier.height(20.dp))

            // AUTO SCROLL CAROUSEL 1
            Card(
                modifier = Modifier.padding(16.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                AutoSlidingCarousel(
                    itemsCount = imagesCarousel1.size,
                    itemContent = { index ->
                        Image(
                            painter = painterResource(id = imagesCarousel1[index]),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.height(200.dp)
                        )
                    }
                )
            }

            // Gharaana Text
            Text(
                text = "GHARAANA",
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

            // SERVICES BOX
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(200.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(colorResource(id = R.color.light_grey)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {


                Text(
                    text = "All Services",
                    color = Color.Black,
                    fontSize = 15.sp,
                    letterSpacing = 5.sp,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(0.9f),
                    horizontalArrangement = Arrangement.Center
                ) {

                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    ) {

                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    ) {

                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    ) {

                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    ) {

                    }

                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(0.9f),
                    horizontalArrangement = Arrangement.Center
                ) {

                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    ) {

                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    ) {

                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    ) {

                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    ) {

                    }

                }


            }

            Spacer(modifier = Modifier.height(10.dp))

//            // AUTO SCROLL CAROUSEL 2
//            Card(
//                modifier = Modifier.padding(16.dp),
//                shape = RoundedCornerShape(16.dp),
//            ) {
//                AutoSlidingCarousel(
//                    itemsCount = imagesCarousel2.size,
//                    itemContent = { index ->
//                        Image(
//                            painter = painterResource(id = imagesCarousel2[index]),
//                            contentDescription = null,
//                            contentScale = ContentScale.Crop,
//                            modifier = Modifier.height(200.dp)
//                        )
//                    }
//                )
//            }

//////////////////////////////////////////////////////////////////////////////////
            
            // FREQUENTLy USED SERVICES

            Column(
                //verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(100.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(colorResource(id = R.color.light_grey))

            ) {
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Popular",
                    color = Color.Black,
                    fontSize = 15.sp,
                    letterSpacing = 5.sp,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center,

                )

                Spacer(modifier = Modifier.height(3.dp))

                LazyRow(
                    state = listState,
                    modifier = Modifier
                        .weight(1f) // Occupy the remaining space
                        .padding(5.dp) // Padding between the row and button
                ) {
                    items(frequentlyUsedServices.size) { index ->

                        Card(
                            modifier = Modifier
                                .size(80.dp) // Set size of the card
                                .padding(horizontal = 4.dp),
                            //elevation = CardDefaults.cardElevation(10.dp)
                        ) {
                            Box(modifier = Modifier
                                .fillMaxSize()
                                .background(colorResource(id = R.color.light_grey)),
                                contentAlignment = Alignment.Center){
                                Image(
                                    modifier = Modifier.size(60.dp),
                                    painter = painterResource(id = frequentlyUsedServices[index]),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                }


            }
            
            Spacer(modifier = Modifier.height(30.dp))

            // WHY CHOOSE GHARAANNA

            Card(modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(20.dp))
                .background(colorResource(id = R.color.light_grey))) {

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Why Choose Gharaana",
                    color = Color.Black,
                    fontSize = 15.sp,
                    letterSpacing = 5.sp,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                    )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.why_choose_gharaana),
                    color = Color.Black,
                    fontSize = 15.sp,
                    letterSpacing = 3.sp,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic
                )
            }
            
            Spacer(modifier = Modifier.height(100.dp))

        }
    }
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}