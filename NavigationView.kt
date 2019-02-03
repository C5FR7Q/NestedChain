package com.example.qwe2r.myapplication

interface NavigationView {
    fun openBaseNavigation()
    fun openBaseNavigation(action: (NavigationView) -> Unit)
    fun showToast(text: String)
}