package com.simuelunbo.wanted_preonboarding_android.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.simuelunbo.wanted_preonboarding_android.R
import com.simuelunbo.wanted_preonboarding_android.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var navHost: NavHost

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        setUpBottomNavigationView()
        initToolbar()
        viewModelCallback()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
    }

    private fun setUpBottomNavigationView() {
        navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        binding.bottomNavi.setupWithNavController(navHost.navController)
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navHost.navController)
    }

    private fun viewModelCallback() {
        viewModel.toolbarTitle.observe(this) { title ->
            supportActionBar?.title = title
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navHost.navController.navigateUp() || super.onSupportNavigateUp()
    }
}