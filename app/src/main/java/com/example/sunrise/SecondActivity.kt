package com.example.sunrise

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class SecondActivity : ComponentActivity() {
    private val TAG = "SecondActivity-Lifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: 首次创建")

        setContent {
            SecondScreen {
                // 点击按钮关闭当前 Activity（返回 MainActivity）
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: 开始可见")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: 可交互")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: 失去焦点")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: 完全不可见")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: 从停止状态恢复")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: 销毁")
    }
}

// SecondActivity 的界面
@Composable
fun SecondScreen(onFinish: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("这是第二个 Activity")
        Button(onClick = onFinish) {
            Text("返回第一个 Activity")
        }
    }
}