package com.example.androidapp.mybooks

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidapp.AppTheme
import com.example.androidapp.BottomNavBar
import com.example.androidapp.R

@Composable
fun MyBooksScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        },
        modifier = Modifier
            .fillMaxSize()

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                stringResource(R.string.my_books_screen_title),
                modifier = Modifier.padding(innerPadding),
                style = MaterialTheme.typography.headlineLarge,
            )

        }
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark",
    showBackground = true
)
@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight",
    showBackground = true
)
@Composable
fun MyBooksScreenPreviewLight() {
    AppTheme {
        var navController = rememberNavController()
        MyBooksScreen(navController)
    }

}