package com.example.qwe2r.myapplication

import android.support.v4.app.FragmentManager

class Router {

    companion object {
        private const val CONTAINER_ID = R.id.base_fragment_container
    }

    lateinit var fragmentManager: FragmentManager

    private val postponedTransactionInfoList = mutableListOf<TransactionInfo>()

    fun postponeBaseNavigation(): NavigationView {
        return NavigationFragment().also {
            postponedTransactionInfoList.add(TransactionInfo(it, it.javaClass.name, false))
        }
    }

    fun commitPostponed() {
        postponedTransactionInfoList.takeIf { !it.isEmpty() }?.run {
            forEach { changeFragment(it) }
            clear()
        }

    }

    fun openNavigation(): NavigationFragment {
        val fragment = NavigationFragment()
        changeFragment(TransactionInfo(fragment, fragment.javaClass.name, false))
        return fragment
    }

    fun changeFragment(transactionInfo: TransactionInfo) {
        fragmentManager.beginTransaction()
                .apply {
                    if (transactionInfo.saveToBackStack) {
                        addToBackStack(transactionInfo.tag)
                    }
                }
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(CONTAINER_ID, transactionInfo.fragment, transactionInfo.tag)
                .commit()
    }
}