package com.example.qwe2r.myapplication

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import java.util.*

open class NavigationFragment : BaseFragment(), NavigationView {

    private val router = Router()

    override val onExecuteState = State.STARTED

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


    override fun openBaseNavigation() {
        executeDeferredAction {
            router.openNavigation()
        }
    }

    override fun openBaseNavigation(action: (NavigationView) -> Unit) {
        executeDeferredAction {
            router.openNavigation().also { action.invoke(it) }
        }
    }

    override fun showToast(text: String) {
        executeDeferredAction {
            Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
        }
    }
}