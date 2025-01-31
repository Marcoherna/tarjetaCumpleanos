package cl.kayohimu.tarjetadecumpleanos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.kayohimu.tarjetadecumpleanos.ui.theme.TarjetaDeCumpleanosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TarjetaDeCumpleanosTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        name = "Elizabeth",
                        from = "Marco",


                    )

                }
            }
        }
    }
}

@Composable
fun GreetingText(name: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    )  {

        Text(
            text = "¡Feliz cumpleaños $name!",
            fontSize = 50.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = "De $from",
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.End)
        )
    }
}

@Composable
fun GreetingImage(name: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            name = name,
            from = from,
            modifier = modifier.fillMaxSize().padding(8.dp)
        )
    }
}

@Preview(showBackground = true,
    name = "Mi Tarjeta")
@Composable
fun BirthdayCardPreview() {
    TarjetaDeCumpleanosTheme {
        GreetingText("Elizabeth","Marco")

    }
}

@Preview(showBackground = true,)
@Composable
fun GreetingImagePreview() {
    TarjetaDeCumpleanosTheme {
        GreetingImage("Elizabeth","Marco")
    }
}