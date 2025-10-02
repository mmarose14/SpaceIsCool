package com.spaceiscool.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.spaceiscool.R
import com.spaceiscool.base.BaseActivity
import com.spaceiscool.neo.NEOActivity
import com.spaceiscool.pictureoftheday.APODActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(
                onApodClick = {
                    startActivity(Intent(this, APODActivity::class.java))
                },
                onNeoClick = {
                    startActivity(Intent(this, NEOActivity::class.java))
                }
            )
        }
    }
}

@Composable
fun MainScreen(onApodClick: () -> Unit, onNeoClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onApodClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = androidx.compose.ui.graphics.Color.Blue,
                contentColor = androidx.compose.ui.graphics.Color.White
            ),
        ) {
            Text(text = stringResource(id = R.string.apod_button))
        }
        Button(
            onClick = onNeoClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = androidx.compose.ui.graphics.Color.Blue,
                contentColor = androidx.compose.ui.graphics.Color.White
            ),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Near Earth Objects")
        }
    }
}
