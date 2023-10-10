package com.mcvector36.reportloto

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.mcvector36.reportloto.ui.theme.ReportLotoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReportLotoTheme {
                WebViewComponent()
            }
        }
    }
}

@Composable
fun WebViewComponent() {


    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
                loadUrl("https://www.loto.ro/?p=3872") // Înlocuiește cu URL-ul paginii web dorite
            }
        },
        update = { view ->
            view.loadUrl("https://www.loto.ro/?p=3872") // Înlocuiește cu URL-ul paginii web dorite
        }
    )
}
