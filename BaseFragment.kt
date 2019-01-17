package com.example.qwe2r.myapplication

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

open class BaseFragment : Fragment() {
    protected var attached = false
    protected var created = false
    protected var viewCreated = false
    protected var started = false
    protected var resumed = false

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        attached = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        created = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewCreated = true
    }

    override fun onStart() {
        super.onStart()
        started = true
    }

    override fun onResume() {
        super.onResume()
        resumed = true
    }

    override fun onPause() {
        super.onPause()
        resumed = false
    }

    override fun onStop() {
        super.onStop()
        started = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewCreated = false
    }

    override fun onDestroy() {
        super.onDestroy()
        created = false
    }

    override fun onDetach() {
        super.onDetach()
        attached = false
    }
}