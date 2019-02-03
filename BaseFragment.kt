package com.example.qwe2r.myapplication

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject

open class BaseFragment : Fragment() {

    enum class State {
        NONE,
        ATTACHED,
        CREATED,
        VIEW_CREATED,
        STARTED,
        RESUMED
    }

    private val subject: Subject<State> = BehaviorSubject.createDefault(State.NONE)


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        subject.onNext(State.ATTACHED)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subject.onNext(State.CREATED)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subject.onNext(State.VIEW_CREATED)
    }

    override fun onStart() {
        super.onStart()
        subject.onNext(State.STARTED)
    }

    override fun onResume() {
        super.onResume()
        subject.onNext(State.RESUMED)
    }

    override fun onPause() {
        super.onPause()
        subject.onNext(State.STARTED)
    }

    override fun onStop() {
        super.onStop()
        subject.onNext(State.VIEW_CREATED)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        subject.onNext(State.CREATED)
    }

    override fun onDestroy() {
        super.onDestroy()
        subject.onNext(State.ATTACHED)
    }

    override fun onDetach() {
        super.onDetach()
        subject.onNext(State.NONE)
    }

    protected fun executeDeferredAction(action: () -> Unit) {
        subject.filter { canBeExecuted(it) }.firstElement().subscribe { action.invoke() }
    }

    protected open val onExecuteState = State.RESUMED

    private fun canBeExecuted(state: State) = state.ordinal >= onExecuteState.ordinal
}