package com.ananananzhuo.constraintlayoutsample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ananananzhuo.constraintlayoutsample.databinding.ActivityShowlayoutBinding

/**
 * 展示布局的activity
 */
class ShowLayoutActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityShowlayoutBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layoutId = intent.getIntExtra("layoutId", R.layout.layout_baseline)
        setContentView(binding.root)
        binding.tvDesc.text = intent.getStringExtra("desc")
        initToolbar()
        layoutInflater.inflate(layoutId, binding.container, true)
    }

    private fun initToolbar() {
        binding.toolbar.title = intent.getStringExtra("title")
        binding.toolbar.setTitleTextColor(Color.WHITE)
    }
}