package com.gharaana.Models

import com.gharaana.R

data class CarouselModel(
    val title: String,
    val rating: Float,
    val desc: String,
    val imaUrl: Int
)

val natural = listOf(
    CarouselModel("Sample1", 4.0f, "hello", R.drawable.a),
    CarouselModel("Sample1", 4.0f, "hello", R.drawable.b),
    CarouselModel("Sample1", 4.0f, "hello", R.drawable.c),
    CarouselModel("Sample1", 4.0f, "hello", R.drawable.d),
    CarouselModel("Sample1", 4.0f, "hello", R.drawable.e)
)
