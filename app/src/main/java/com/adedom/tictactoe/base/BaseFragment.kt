package com.adedom.tictactoe.base

import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.adedom.tictactoe.utils.toast

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    protected inline fun <reified T> LiveData<T>.observe(crossinline onNext: (T) -> Unit) {
        observe(this@BaseFragment, { onNext(it) })
    }

    protected fun LiveData<Throwable>.observeError() {
        observe(this@BaseFragment, {
            it.printStackTrace()
            context.toast("BaseFragment : observeError ${it.message}", Toast.LENGTH_LONG)
        })
    }

}
