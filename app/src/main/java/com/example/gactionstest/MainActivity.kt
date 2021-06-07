package com.example.gactionstest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intent?.handleIntent()
    }

    private fun Intent.handleIntent(){
        when(action){
            Intent.ACTION_VIEW -> handleDeepLink(data)
            else -> gotoDefaultView()
        }
    }

    private fun handleDeepLink(data: Uri?) {
        when(data?.path){
            "/open" ->  {
                val featureType = data.getQueryParameter("featureName").orEmpty()
                navigatetoActivity(featureType)
            }
        }

        when(data?.path){
            "/ordermakanan" -> {
                val orderMakanan = data.getQueryParameter("menuItemName").orEmpty()
                navigatetoActivity(orderMakanan)

            }
        }
    }

    private fun navigatetoActivity(featureType: String) {
        Log.d("Feature_Type:", featureType)
        when(featureType){
            "profiles" -> {
                val profileIntent = Intent(this, ProfileActivity::class.java)
                startActivity(profileIntent)
                Log.d("Halaman", "Profile")
            }
            "settings" -> {
                val settingIntent = Intent(this, SettingsActivity::class.java)
                startActivity(settingIntent)
                Log.d("Halaman", "setttng")
            }
            "foodMenu" -> {
                val foodMenuIntent = Intent(this, FoodMenuActivity::class.java)
                startActivity(foodMenuIntent)
                Log.d("Halaman", "Food Menu")
            }
        }
    }


    private fun gotoDefaultView() {
//        TODO("Not yet implemented")
//        val mainIntent = Intent(this, ProfileActivity::class.java)
//        startActivity(mainIntent)
    }
}