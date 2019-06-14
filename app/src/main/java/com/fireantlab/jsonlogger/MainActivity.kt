package com.fireantlab.jsonlogger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fireantlab.jsonloggerlib.JsonLogger

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        JsonLogger.logJson("[{ \"id\":\"1\", \"name\":\"John\" }, { \"id\":\"2\", \"name\":\"Maverick\" }, { \"id\":\"3\", \"name\":\"Joseph\" }]")
    }
}
