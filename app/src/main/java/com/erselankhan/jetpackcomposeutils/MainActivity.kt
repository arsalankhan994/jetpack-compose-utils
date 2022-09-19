package com.erselankhan.jetpackcomposeutils

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.erselankhan.jetpackcomposeutils.ui.theme.JetpackComposeUtilsTheme
import com.erselankhan.jetpackcomposeutils.utils.urlToBitmap

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeUtilsTheme {
                val scope = rememberCoroutineScope()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                    urlToBitmap(
                        scope = scope,
                        imageURL = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg",
                        context = LocalContext.current,
                        onSuccess = {
                            it
                        },
                        onError = {
                            it
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeUtilsTheme {
        Greeting("Android")
    }
}