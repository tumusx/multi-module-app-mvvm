package com.github.tumusx.shoppinglistitems

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.tumusx.presenter.views.fragment.SearchImageFragment
import com.github.tumusx.shoppinglistitems.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        onInflateFragment()
        setContentView(binding.root)
    }

    private fun onInflateFragment() {
        val searchImageFragment = SearchImageFragment()
        supportFragmentManager.beginTransaction()
            .add(binding.fragmentContainer.id, searchImageFragment, searchImageFragment.tag)
            .commitAllowingStateLoss()
    }

}