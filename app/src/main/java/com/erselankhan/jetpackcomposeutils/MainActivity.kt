package com.erselankhan.jetpackcomposeutils

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.erselankhan.jetpackcomposeutils.ui.theme.JetpackComposeUtilsTheme
import com.erselankhan.jetpackcomposeutils.utils.urlToBitmap

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeUtilsTheme {
                val scope = rememberCoroutineScope()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
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
