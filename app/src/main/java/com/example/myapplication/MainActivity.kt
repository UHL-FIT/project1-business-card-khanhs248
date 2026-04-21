package com.example.myapplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D4)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center // Căn giữa theo chiều dọc [cite: 945]
        ) {
            Image(
                // Đảm bảo tên file ảnh của bạn trong thư mục drawable là android_logo
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null, // Đặt là null vì hình ảnh chỉ để trang trí
                modifier = Modifier
                    .size(120.dp)
                    .background(Color(0xFF073042))
            )

            Spacer(modifier = Modifier.height(8.dp)) // Tạo khoảng cách [cite: 1001]

            Text(
                text = "Khánh Đăng",
                fontSize = 45.sp,
                fontWeight = FontWeight.Light
            )

            Text(
                text = "abcxzyyyyyy",
                color = Color(0xFF3ddc84), // Sử dụng màu mã hex tuỳ chỉnh xanh lục của Android [cite: 1003, 1004, 1005, 1006]
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp) // Căn lề để tạo khoảng cách [cite: 1000]
            )
        }

        // --- PHẦN 2: THÔNG TIN LIÊN HỆ ---
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Gọi hàm ContactRow để vẽ từng dòng thông tin
            ContactRow(
                icon = Icons.Rounded.Phone,
                text = "0919559578"
            )
            ContactRow(
                icon = Icons.Rounded.Share,
                text = "Fb:Khánh Đăng"
            )
            ContactRow(
                icon = Icons.Rounded.Email,
                text = "dairyuki2482005@gmail.com"
            )
        }
    }
}

// Hàm này giúp tạo ra một hàng chứa Icon và Text để dùng lại nhiều lần
@Composable
fun ContactRow(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(0.7f),
        verticalAlignment = Alignment.CenterVertically // Căn giữa theo chiều dọc
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null, // Nhớ điền tham số contentDescription [cite: 996]
            tint = Color(0xFF1B5E20), // Thay đổi tham số Tint để điều chỉnh màu biểu tượng [cite: 995]
            modifier = Modifier.padding(end = 24.dp)
        )
        Text(
            text = text,
            color = Color(0xFF000000)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MaterialTheme {
        BusinessCardApp()
    }
}