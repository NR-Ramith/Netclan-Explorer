package com.ramith.netclanexplorer

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ramith.netclanexplorer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var toolbar: Toolbar
    lateinit var imgbtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = findViewById(R.id.toolbar)
        imgbtn = findViewById(R.id.ibnRefine)
        setUpToolbar()

        imgbtn.setOnClickListener {
            val intent = Intent(this@MainActivity, Refine::class.java)
            startActivity(intent)
        }

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_explore, R.id.navigation_network, R.id.navigation_chat, R.id.navigation_contacts, R.id.navigation_groups
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Howdy N R Ramith !!"
        val toolbar: Toolbar = findViewById(R.id.toolbar)

        // Get the default title TextView
        val titleTextView: TextView = toolbar.getChildAt(0) as TextView

        // Modify the properties of the title TextView
        titleTextView.textSize = 16f
        //titleTextView.setTextColor(Color.RED)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.apply {
            val subtitleText = "Jayanagar, Bengaluru"

            val spannableString = SpannableString("  $subtitleText")

            val iconDrawable = resources.getDrawable(R.drawable.ic_baseline_location_on_24)
            iconDrawable.setBounds(0, 0, iconDrawable.intrinsicWidth, iconDrawable.intrinsicHeight)

            val imageSpan = ImageSpan(iconDrawable, ImageSpan.ALIGN_BOTTOM)
            spannableString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            subtitle = spannableString
        }
    }

}