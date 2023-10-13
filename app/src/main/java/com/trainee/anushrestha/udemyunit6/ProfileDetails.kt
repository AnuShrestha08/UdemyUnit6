package com.trainee.anushrestha.udemyunit6

/**
 * Adding data class as these properties can't be same.
 * There exists different details of each users
 */
data class ProfileDetails(
    val name:String,
    val status : Boolean,
    val drawableImage : Int) //int as image is drawable

val profileDetailsList = arrayListOf<ProfileDetails>(
    ProfileDetails(name = "Surprise", status = true, drawableImage = R.drawable.pp),
    ProfileDetails(name = "Shock", status = false, drawableImage = R.drawable.img),
)
