package com.adedom.tictactoe.presentation

import android.os.Bundle
import com.adedom.tictactoe.R
import com.adedom.tictactoe.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
