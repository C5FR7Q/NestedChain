package com.example.qwe2r.myapplication

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*

open class NavigationFragment : BaseFragment(), NavigationView {

    private val router = Router()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        router.fragmentManager = childFragmentManager
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_base, container, false).apply {
            val rnd = Random()
            findViewById<View>(R.id.base_root).setBackgroundColor(
                    Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            )
        }
    }

    override fun onStart() {
        super.onStart()
        router.commitPostponed()
    }

    override fun openBaseNavigation(): NavigationView {
        val baseNavigation = router.postponeBaseNavigation()

        router.takeIf { started }?.run { commitPostponed() }

        return baseNavigation
    }
}