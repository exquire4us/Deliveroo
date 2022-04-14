package com.example.deliveroo.model

import com.example.deliveroo.R

val onboardPages = listOf<Page>(
    Page(
        "Top Asian Chefs",
        "We cook all our lives a day , and for our guest this may only be the Sumo visit in his life ." +
                "We want it to be remembered forever",
        R.drawable.man_doing_the_seitan_cooking_process_at_home_how_2021_08_29_00_31_58_utc_2_11zon
    ),
    Page(
        "Tasty and fresh ",
        "The range of best delicious Asian meals. Our main trend at all times is very tasty and made with fresh products",
        R.drawable.asian_noodles_with_shrimps_in_bowl_minimal_red_ba_2021_12_14_23_37_56_utc_1_11zon

    ),
    Page(
        "Konnichiwa!",
        "Best Asian bistro restaurant in the city , We provide fast delivery from 20 minutes after order ",
        R.drawable.stir_fry_chicken_sweet_peppers_and_green_onion_a_2021_08_26_23_07_27_utc_3_11zon
    )
)

val categoriesList = listOf(Categories.Lunch, Categories.Snacks, Categories.IceCream, Categories.Dessert)


sealed class Categories(val title: String , val Icon : Int){
    object Lunch : Categories("Lunch",R.drawable.lunch_icon)
    object Dessert: Categories("Dessert", R.drawable.ic_cupcake)
    object IceCream: Categories("Ice Cream",R.drawable.ic_ice_cream_1)
    object Snacks: Categories("Snacks", R.drawable.ic_fruit_kebab_1)
}