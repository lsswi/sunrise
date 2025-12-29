package com.example.sunrise.ui.components.base

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// 定义第一个Compose组件：标题文本
@Composable
fun BaseText(text: String, fontSize: Int, fontWeight: FontWeight) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        fontWeight = fontWeight
    )
}