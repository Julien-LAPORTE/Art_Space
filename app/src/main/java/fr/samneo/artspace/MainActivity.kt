package fr.samneo.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.samneo.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp(Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var id by remember {
        mutableStateOf(1)
    }
    val artBank = ArtBank(id)

    val marginModifier = Modifier
        .fillMaxWidth()
        .padding(start = 24.dp, end = 24.dp)


    Column(verticalArrangement = Arrangement.SpaceBetween) {
        Spacer(modifier = Modifier.width(0.dp))// Spacer qui sert juste pour descendre l'image grace à l'arrangement de la column
        ArtImageAndTitle(
            title = artBank?.title ?: "", id = id, modifier = marginModifier
        )

        Column(
            marginModifier.wrapContentSize(Alignment.BottomCenter)
        ) {
            AuthorOfArtAndYear(
                artBank?.author, artBank?.year, marginModifier
            )
            Spacer(modifier = Modifier.height(24.dp))
            PreviousAndNextButtons(
                onClickPrevious = { if (id != 1) id-- else id = artBank.maxId },
                onClickNext = { if (id < artBank.maxId) id++ else id = 1 },
                marginModifier
            )
        }
    }


}

@Composable
fun ArtImageAndTitle(title: String, id: Int, modifier: Modifier = Modifier) {
    val image: Int? = when (id) {
        1 -> R.drawable._1
        2 -> R.drawable._2
        3 -> R.drawable._3
        4 -> R.drawable._4
        5 -> R.drawable._5
        6 -> R.drawable._6
        7 -> R.drawable._7
        else -> null
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            title, fontSize = 24.sp, fontWeight = FontWeight.Bold
        )
        Surface(modifier, color = Color.Black) {
            Image(
                painterResource(id = image ?: R.drawable.image_not_found_scaled_1150x647),
                null,
                Modifier.padding(16.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun AuthorOfArtAndYear(author: String?, year: Int?, modifier: Modifier = Modifier) {
    Surface(
        modifier, color = MaterialTheme.colorScheme.secondary
    ) {
        Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceAround) {
            Text(author ?: "Unknown author")
            Spacer(modifier = Modifier.width(24.dp))
            Text(year?.toString() ?: "Unknown year")
        }
    }
}

@Composable
fun PreviousAndNextButtons(
    onClickPrevious: () -> Unit, onClickNext: () -> Unit, modifier: Modifier = Modifier
) {
    Row {
        Spacer(modifier = Modifier.weight(0.25f))
        Button(onClick = onClickPrevious, modifier = Modifier.weight(1F)) {
            Text(stringResource(id = R.string.previous))
        }
        Spacer(modifier = Modifier.weight(0.5f))
        Button(onClick = onClickNext, modifier = Modifier.weight(1F)) {
            Text(stringResource(id = R.string.next))
        }
        Spacer(modifier = Modifier.weight(0.25f))
    }
}

@Preview
@Composable
fun ArtImageAndTitlePreview() {
    ArtSpaceTheme {
        ArtImageAndTitle(title = "Test d'un titre", id = 1)
    }
}

@Preview
@Composable
fun AuthorOfArtAndYearPreview() {
    ArtSpaceTheme {
        AuthorOfArtAndYear(null, 1932)
    }
}

@Preview
@Composable
fun PreviousAndNextButtonsPreview() {
    ArtSpaceTheme {
        PreviousAndNextButtons({/* Just for preview */ }, { /* Just for preview */ })
    }
}