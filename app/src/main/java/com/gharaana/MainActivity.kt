package com.gharaana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.gharaana.presentation.NavGraph.SetNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SetNavGraph()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}



// git status
// git add .
// git status
// git commit -m "your message"
// git push origin shani
// then create a pull request


// git pull upstream master