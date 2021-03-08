package com.tronindmitr.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.createGraph
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView

//import com.tronindmitr.lab2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawerLayout)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_) as NavHostFragment
        val navController = navHostFragment.navController

        val topLevelDestination = setOf(R.id.step1, R.id.step4, R.id.step6, R.id.step7, R.id.step8)

        appBarConfiguration = AppBarConfiguration(topLevelDestination, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        findViewById<NavigationView>(R.id.nav_view).setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}