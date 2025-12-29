package com.example.sunrise

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sunrise.ui.components.base.BaseText
import com.example.sunrise.ui.theme.SunriseTheme

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity-Lifecycle"

    // 生命周期方法：Activity 首次创建时调用
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: 首次创建")

        setContent {
            SunriseTheme {
                MainScreen {
                    // 点击按钮跳转到 SecondActivity
                    val intent = Intent(this, SecondActivity::class.java)
                    startActivity(intent)
                }

            }
        }
    }

    // 生命周期方法：Activity 可见但未交互时调用
    override fun onStart() {
        super.onStart()
        val t = Test()
        println("damn Test str init: ${t.str}")
        t.str = "init 1"
        Log.i(TAG, "damn Test set 1: ${t.str}")
        t.str = "init 2"
        Log.i(TAG, "damn Test set 2: ${t.str}")
        Log.d(TAG, "onStart: 开始可见")
    }

    // 生命周期方法：Activity 可见且可交互时调用
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: 可交互")
    }

    // 生命周期方法：被其他 Activity 遮挡时调用（部分可见）
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: 失去焦点")
    }

    // 生命周期方法：完全不可见时调用
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: 完全不可见")
    }

    // 生命周期方法：从停止状态恢复时调用（先于 onResume）
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: 从停止状态恢复")
    }

    // 生命周期方法：Activity 销毁时调用
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: 销毁")
    }

    // 保存状态（如屏幕旋转时）
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: 保存状态")
    }
}

// MainActivity 的界面
@Composable
fun MainScreen(onNavigate: () -> Unit) {
    var displayText by remember { mutableStateOf("这是第一个 Activity") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(horizontal = 10.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("你好你好")
            Button(
                onClick = { }
            ) { Text("按钮Row") }
        }

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(displayText)
            Button(
                onClick = {
                    // 3. 点击时修改状态变量，触发 UI 重组
                    displayText = "按钮点击后修改的文本"
                },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text("修改文本内容")
            }

            BaseText("这是封装的一个文字组件", 20, FontWeight.Thin)

            Button(onClick = onNavigate) {
                Text("跳转到第二个 Activity")
            }
        }
    }

}

// 关键：给 MainScreen 写 Preview，显式包裹 SunriseTheme
@Preview(showBackground = true, name = "MainScreen Preview")
@Composable
fun MainScreenPreview() {
    // 即使 Theme 默认关闭了 dynamicColor，Preview 中也显式传 false 更稳妥
    SunriseTheme(dynamicColor = false) {
        MainScreen {}
    }
}

class MyDelegate {
    private var innerStr: String = "default"
    operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): String {
        return innerStr
    }

    operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: String) {
        innerStr = value
        println("damn set new value: $value")
    }
}

class Test {
    var str: String by MyDelegate()
}