package com.example.qwe2r.myapplication

data class TransactionInfo(
        val fragment: NavigationFragment,
        val tag: String,
        val saveToBackStack: Boolean
)