package com.example.qwe2r.myapplication

data class TransactionInfo(
        val fragment: BaseFragment,
        val tag: String,
        val saveToBackStack: Boolean
)