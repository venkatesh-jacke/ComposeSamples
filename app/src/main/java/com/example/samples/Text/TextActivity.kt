package com.example.samples.Text

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle


import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.*
import androidx.compose.ui.text.withStyle


class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextExamples()
        }
    }

    @Composable
    private fun TextExamples() {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            SimpleText()
            Divider()
            StyleText()
            Divider()
            FontText()
            Divider()
            TextOverflow()
            Divider()
            TextAlign()
            Divider()
            TextWithClick()
            Divider()
            TextSpanRange()
            Divider()
            TextSpanRangeClick()
            Divider()
            TextSelection()
            Divider()


        }

    }
@Composable
private fun TextSelection(){
    SelectionContainer {
        Text(text = "Text Selection ", modifier = Modifier.padding(10.dp).fillMaxWidth(),color = Color.Blue, textAlign = TextAlign.Center)
    }
}

    @Composable
    private fun TextSpanRangeClick() {
        val context = LocalContext.current
        val spanRangeClickText = buildAnnotatedString {
            append("Coding with venki " +
                    "")
            pushStringAnnotation(
                tag = "tag",
                annotation = "Subscribe coding with venki is very useful",
                )
            withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.ExtraBold)) {
                append("Subscribe")
            }
            pop()


        }
        ClickableText(text = spanRangeClickText, onClick ={offset->
            spanRangeClickText.getStringAnnotations(tag="tag",start=offset,end=offset).firstOrNull()?.let { annotation->
                Toast.makeText(context,annotation.item,Toast.LENGTH_LONG).show()
            }


        } )

    }

    @Composable
    private fun TextSpanRange() {
        Text(
            buildAnnotatedString {
                append("This is ")
                withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.ExtraBold)) {
                    append("TextWithSpan")
                }
                append(" ")
                withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)) {
                    append("Example")

                }
            }
        )
    }

    @Composable
    private fun TextWithClick() {
        val context = LocalContext.current
        Text(
            text = "Click me",
            color = Color.Red,
            modifier = Modifier
                .padding(10.dp)
                .clickable {
                    Toast
                        .makeText(context, "Clicked", Toast.LENGTH_SHORT)
                        .show()
                })
    }

    @Composable
    private fun SimpleText() {
        Text(text = "Hello World", modifier = Modifier.padding(10.dp))
    }

    @Composable
    private fun StyleText() {
        Text(
            text = "Hello World",
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.h3
        )

    }

    @Composable
    private fun FontText() {
        Text(
            text = "Hello World",
            modifier = Modifier.padding(10.dp),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
            letterSpacing = 10.sp
        )

    }

    @Composable
    private fun TextOverflow() {
        Text(
            text = "lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.body2,

            )

    }

    // should fillMax width and height in case of optimizing entire screen size and not just the text area like xml in gravity
    @Composable
    private fun TextAlign() {

        Text(
            text = "Hello World",
            color = Color.Red,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,

            )
        Text(
            text = "Hello World",
            color = Color.Blue,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.End,

            )
    }

}


//Divides the individual TextComponents for better readability
@Composable
private fun Divider() {
    Spacer(
        modifier =
        Modifier
            .padding(vertical = 5.dp)
            .height(1.dp)
            .fillMaxWidth()
            .background(Color.Black)
    )
}




