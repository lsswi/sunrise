package com.example.sunrise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.sunrise.ui.theme.SunriseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SunriseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column() {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = {
            // 点击按钮时执行的逻辑（如跳转页面、提交数据等）
            println("按钮被点击了！")
        }, colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1677FF)
        )) {
            // Button 的内容（通常是 Text，也可以是图标等）
            Text("点我点我点我")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SunriseTheme {
        Greeting("Android")
    }
}