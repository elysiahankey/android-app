package com.example.androidapp

import android.content.Context
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@VisibleForTesting
fun GetTargetString(@StringRes stringInt: Int): String =
    InstrumentationRegistry.getInstrumentation().targetContext.getString(stringInt)

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    lateinit var navController: TestNavHostController

    @Before
    fun setUpNavHost() {
        composeTestRule.setContent {
            // Creates a TestNavHostController
            navController =
                TestNavHostController(LocalContext.current)
            // Sets a ComposeNavigator to the navController so it can navigate through composables
            navController.navigatorProvider.addNavigator(
                ComposeNavigator()
            )
            NavHost(
                navController = navController
            )
        }
    }

    @Test
    fun navHost_verifyHomeStartDestination() {
        composeTestRule
            .onNodeWithText(GetTargetString(R.string.welcome_message))
            .assertIsDisplayed()
    }

    @Test
    fun navHost_clickGetStarted_navigatesToSearch() {
        composeTestRule
            .onNodeWithText(GetTargetString(R.string.get_started_button))
            .performClick()

        composeTestRule
            .onNodeWithText(GetTargetString(R.string.search_intro_message))
            .assertIsDisplayed()
    }
}