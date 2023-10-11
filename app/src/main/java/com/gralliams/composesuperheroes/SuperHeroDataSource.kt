package com.gralliams.composesuperheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SuperHero(
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)

class SuperHeroDataSource{

    companion object{
        val superHeros = listOf(
            SuperHero(
                nameRes = R.string.hero1,
                descriptionRes = R.string.description1,
                imageRes = R.drawable.android_superhero1
            ),

            SuperHero(
                nameRes = R.string.hero2,
                descriptionRes = R.string.description2,
                imageRes = R.drawable.android_superhero2
            ),

            SuperHero(
                nameRes = R.string.hero3,
                descriptionRes = R.string.description3,
                imageRes = R.drawable.android_superhero3
            ),

            SuperHero(
                nameRes = R.string.hero4,
                descriptionRes = R.string.description4,
                imageRes = R.drawable.android_superhero4
            ),

            SuperHero(
                nameRes = R.string.hero5,
                descriptionRes = R.string.description5,
                imageRes = R.drawable.android_superhero5
            ),

            SuperHero(
                nameRes = R.string.hero6,
                descriptionRes = R.string.description6,
                imageRes = R.drawable.android_superhero6
            )
        )
    }
}