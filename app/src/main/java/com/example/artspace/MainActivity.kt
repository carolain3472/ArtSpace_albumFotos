package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen( modifier: Modifier = Modifier) {


    var artWork by remember { mutableStateOf(1) }

    val imageResource = when (artWork) {
        1 -> R.drawable.photo_0
        2 -> R.drawable.photo_1
        3 -> R.drawable.photo_2
        4 -> R.drawable.photo_3
        5 -> R.drawable.photo_4
        6 -> R.drawable.photo_5
        7 -> R.drawable.photo_6
        8 -> R.drawable.photo_7
        9 -> R.drawable.photo_8
        10 -> R.drawable.photo_9
        else -> R.drawable.photo_9
    }

    val titleResource = when (artWork) {
        1 -> R.string.foto0
        2 -> R.string.foto1
        3 -> R.string.foto2
        4 -> R.string.foto3
        5 -> R.string.foto4
        6 -> R.string.foto5
        7 -> R.string.foto6
        8 -> R.string.foto7
        9 -> R.string.foto8
        10 -> R.string.foto9
        else -> R.string.foto9
    }

    val yearResource = when (artWork) {
        1 -> R.string.foto0_año
        2 -> R.string.foto1_año
        3 -> R.string.foto2_año
        4 -> R.string.foto3_año
        5 -> R.string.foto4_año
        6 -> R.string.foto5_año
        7 -> R.string.foto6_año
        8 -> R.string.foto7_año
        9 -> R.string.foto8_año
        10 -> R.string.foto9_año
        else -> R.string.foto9_año
    }

    val descriptionResource = when (artWork) {
        1 -> R.string.foto0_des
        2 -> R.string.foto1_des
        3 -> R.string.foto2_des
        4 -> R.string.foto3_des
        5 -> R.string.foto4_des
        6 -> R.string.foto5_des
        7 -> R.string.foto6_des
        8 -> R.string.foto7_des
        9 -> R.string.foto8_des
        10 -> R.string.foto9_des
        else -> R.string.foto9_des
    }


    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        ArtworkTitle(
            title = R.string.vacio,
            year = R.string.code,
            description = R.string.nombre
        )
        ArtworkImage(
            currentArtwork = imageResource
        )

        ArtworkTitle(
            title = titleResource,
            year = yearResource,
            description = descriptionResource
        )
        Spacer(
            modifier = modifier.size(25.dp)
        )
        Row(
            modifier = modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (artWork == 1){
                        artWork = 10
                    }else{
                        artWork -= 1
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.gray_900),
                    containerColor = colorResource(id = R.color.teal_700)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                )
            ) {
                Text(
                    text = stringResource(R.string.name_boton_previous),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
            Button(
                onClick = { artWork = 1 },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.gray_900),
                    containerColor = colorResource(id = R.color.teal_200)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                ),
            ) {
                Image(painter = painterResource(R.drawable.rotate),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
            Button(
                onClick = {
                    if (artWork == 10){
                        artWork = 1
                    }else{
                        artWork += 1
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.gray_900),
                    containerColor = colorResource(id = R.color.teal_700)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                ),
            ) {
                Text(
                    text = stringResource(R.string.name_boton_next),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

@Composable
fun ArtworkImage(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {

    Image(
        painter = painterResource(id = currentArtwork),
        contentDescription = null,
        modifier = modifier
            .padding(40.dp)
            .height(400.dp)
            .fillMaxWidth()
            .shadow(8.dp,
                shape = MaterialTheme.shapes.medium,
                spotColor = Color.Black )
        ,
        contentScale = ContentScale.FillWidth
    )


}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int,
    @StringRes description: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.teal_700),
            fontSize = 32.sp,
        )
        Text(
            text = stringResource(id = year),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300),
            fontSize = 16.sp,
        )
        Text(
            text = stringResource(id = description),
            modifier = Modifier
                .width(350.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_900),
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}
