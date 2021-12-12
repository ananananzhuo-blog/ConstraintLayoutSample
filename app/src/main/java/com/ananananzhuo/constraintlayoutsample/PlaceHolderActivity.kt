package com.ananananzhuo.constraintlayoutsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ananananzhuo.constraintlayoutsample.databinding.ActivityPlaceHolderBinding

class PlaceHolderActivity : AppCompatActivity() {
    val binding:ActivityPlaceHolderBinding by lazy {
        ActivityPlaceHolderBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.ivPlace.setOnClickListener {
            binding.place1.setContentId(R.id.iv_place)
        }
    }
}