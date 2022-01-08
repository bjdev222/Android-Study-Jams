package com.scetasj.universitydatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment

class HomeActivity : AppCompatActivity() {

    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var window = this.getWindow()
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.getResources().getColor(R.color.black)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.host) as NavHostFragment
        navController = navHostFragment.navController

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        return when (item.itemId) {
            R.id.about -> {
                navController.navigate(R.id.aboutUsFragment)  //2
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}