package com.gralliams.composesuperheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gralliams.composesuperheroes.SuperHeroDataSource.Companion.superHeros
import com.gralliams.composesuperheroes.ui.theme.ComposeSuperheroesTheme
import com.gralliams.composesuperheroes.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SuperHeroesApp(){
        Scaffold(
            topBar = {

            }
        ) { it ->
            LazyColumn(contentPadding = it){
                items(superHeros){
                    HeroCard(
                        superHero = it
                    )
                }

            }

        }
    }

    @Composable
    fun HeroCard(superHero: SuperHero, modifier: Modifier = Modifier){

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            )
        ){
            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
            ){
                HeroPortfolio(superHero = superHero)
                Box(
                    modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(16.dp)
                ){
                    Image(
                        painter = painterResource(id = superHero.imageRes),
                        contentDescription = "Super hero image",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(MaterialTheme.shapes.small)
                            .padding(8.dp),
                        contentScale = ContentScale.Crop
                    )
                }


            }
        }
    }

    @Composable
    fun HeroPortfolio(superHero: SuperHero){
        Column(
            modifier = Modifier.padding(16.dp).height(72.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ){
            Text(
                text = stringResource(id = superHero.nameRes),
                maxLines = Int.MAX_VALUE,
                modifier = Modifier.align(Alignment.Start),
            )
            Text(
                text = stringResource(id = superHero.descriptionRes),
                modifier = Modifier.align(Alignment.Start),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun SuperHeroPreview(){
        ComposeSuperheroesTheme {
//            HeroCard(superHero = SuperHeroDataSource.superHeros[0])
            SuperHeroesApp()
        }
    }
}