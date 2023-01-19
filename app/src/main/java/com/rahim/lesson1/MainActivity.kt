package com.rahim.lesson1

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.rahim.lesson1.databinding.ActivityMainBinding
import com.rahim.lesson1.ui.onBoarding.BoardingAdapter.OnBoardingAdapter


class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





     binding = ActivityMainBinding.inflate(layoutInflater)
     setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navController.navigate(R.id.onBoardingFragment)


        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.task, R.id.profile))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val bottomNavFragments = arrayListOf(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.profile)

        navController.addOnDestinationChangedListener(object: NavController.OnDestinationChangedListener{
            override fun onDestinationChanged(
                controller: NavController,
                destination: NavDestination,
                arguments: Bundle?
            ) {

                navView.isVisible =bottomNavFragments.contains(destination.id)
                if (destination.id == R.id.onBoardingFragment){
                    supportActionBar?.hide()

                }
                else supportActionBar?.show()
            }





        })
    }
}