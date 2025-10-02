package com.spaceiscool.pictureoftheday

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.spaceiscool.R
import com.spaceiscool.base.BaseActivity
import com.spaceiscool.data.model.APOD
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class APODActivity : BaseActivity() {

    private val aPODViewModel: APODViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
            ) { padding ->
                Column(
                    modifier = Modifier.padding(padding)
                ) {
                    val apodState by aPODViewModel.uiState.collectAsState()

                    when (apodState) {
                        is APODUiState.Loading -> Text(text = "Loading")
                        is APODUiState.Success -> APODScreen((apodState as APODUiState.Success).apod)
                        is APODUiState.Error -> Text(text = (apodState as APODUiState.Error).message)
                    }
                }

            }

        }
    }
}

@Composable
fun APODScreen(apod: APOD) {
    Column {
        Text(text = apod.title ?: "No title available")
        AsyncImage(
            model = apod.url,
            contentDescription = "APOD Image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
        Text(text = apod.explanation ?: "No explanation available")
        Text(text = apod.date ?: "No date available")
    }
}

@Preview
@Composable
fun PreviewAPOD() {
    val apod = APOD(
        title = "Title",
        explanation = "Explanation",
        url = "https://example.com/image.jpg"
    )
    APODScreen(apod)
}