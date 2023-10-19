package com.gralliams.composesuperheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    SuperHeroesApp()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SuperHeroesApp() {
        Scaffold(
            topBar = {
                SuperHeroesAppBar()
            }
        ) { contentPadding ->
            LazyColumn(contentPadding = contentPadding) {
                items(superHeros) { superHero ->
                    HeroCard(superHero = superHero)
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun SuperHeroesAppBar() {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                    )
            }
        )
    }

    
    @Composable
    fun HeroCard(superHero: SuperHero, modifier: Modifier = Modifier) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    start =16.dp, end = 16.dp,
                    top = 8.dp, bottom = 8.dp
                ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HeroPortfolio(superHero = superHero)
                Spacer(modifier = Modifier.weight(1f))
                HeroImage(superHero.imageRes)
            }
        }
    }

    @Composable
    fun HeroPortfolio(superHero: SuperHero) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp)
        ) {
            Text(
                text = stringResource(superHero.nameRes),
                style = MaterialTheme.typography.bodyMedium
            )
            TruncatedText(
                text = stringResource(superHero.descriptionRes),
                36
            )
        }
    }

    @Composable
    fun HeroImage(@DrawableRes heroIcon:Int, modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .size(72.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            Image(
                painter = painterResource(heroIcon),
                contentDescription = "Hero image",
                alignment = Alignment.Center,
                contentScale = ContentScale.FillWidth
            )
        }
    }

    @Composable
    fun TruncatedText(text: String, maxLength: Int) {
        val truncatedText = if (text.length > maxLength) {
            text.substring(0, maxLength) + "..."
        } else {
            text
        }

        Text(text = truncatedText, style = MaterialTheme.typography.bodySmall)
    }

    @Preview(showBackground = true)
    @Composable
    fun SuperHeroPreview() {
        ComposeSuperheroesTheme {
            SuperHeroesApp()
        }
    }
}
