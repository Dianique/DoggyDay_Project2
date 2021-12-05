package com.example.doggyday_project2.petviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.core.net.toUri
import coil.load
import com.example.doggyday_project2.R

class MainActivity : AppCompatActivity() {

    private val viewModel: PetViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.dogImagesEntity.observe(this, //
            {
                findViewById<ImageView>(R.id.imageOfPup).load(
                    it.message?.toUri()?.buildUpon()?.scheme("https")?.build()
                    //Sets the ImageView to load pics using the Coil library/dependency.
                    // Translates the key "message" listed from data class into a buildable image.
                )
                findViewById<Button>(R.id.newDogButton).setOnClickListener {
                    //At each click, the viewModel handles the call for retrieving the getNewDog object
                    viewModel.getNewDog()
                }
            })
    }
}


