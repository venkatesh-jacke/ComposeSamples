package com.example.samples

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samples.Text.TextActivity
import com.example.samples.ui.theme.SamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Intent(this,TextActivity::class.java).apply {
                    startActivity(this)
                }
        }
    }
}



//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun DefaultPreview() {
//    SamplesTheme {
//
//    }
//}