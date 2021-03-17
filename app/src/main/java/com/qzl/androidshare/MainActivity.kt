package com.qzl.androidshare

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var btnSystemShare: Button? = null
    private var btnActionBarShare: Button? = null
    private var btnCustomShare: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        btnSystemShare = findViewById<Button>(R.id.btnSystemShare)
        btnActionBarShare = findViewById(R.id.btnActionBarShare)
        btnCustomShare = findViewById(R.id.btnCustomShare)
        btnSystemShare?.setOnClickListener(this)
        btnActionBarShare?.setOnClickListener(this)
        btnCustomShare?.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnSystemShare -> startActivity(SystemShareActivity.createIntent(this))
            R.id.btnActionBarShare -> startActivity(MenuShareProviderActivity.createIntent(this))
            R.id.btnCustomShare -> startActivity(CustomShareActivity.createIntent(this))
        }
    }
}