package com.example.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.example.bank.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.profileFragment2, R.id.inputProfileFragment, R.id.craeteAccountFragment, R.id.showAccountFragment
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.exit -> {
                    finish()
                    true
                }
            }
            NavigationUI.onNavDestinationSelected(it, navController)
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.exit -> {
                    val dialog = AlertDialog.Builder(this)
                    dialog.setTitle(title)
                    dialog.setMessage("Do you want to clear all data?")
                    dialog.setNegativeButton("Cancel") { _, _ ->
                    }
                    dialog.setPositiveButton("Delete") { _, _ ->
                        viewModel.deleteAll()
                        this.finish()
                    }
                    dialog.create().show()
                    Toast.makeText(this, "dfsdfs" , Toast.LENGTH_SHORT).show()
                    true
                }
            }
            NavigationUI.onNavDestinationSelected(it, navController)
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}