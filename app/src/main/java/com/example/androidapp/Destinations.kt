package com.example.androidapp

interface Destination {
    val route: String
}

object Home : Destination {
    override val route = "home"
}

object Search : Destination {
    override val route = "search"
}