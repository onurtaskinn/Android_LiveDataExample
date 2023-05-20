package es.uam.eps.dadm.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import es.uam.eps.dadm.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment())
                .commit()
        }
    }

    override fun onResume() {
        super.onResume()

        binding.generateButton.setOnClickListener {
            viewModel.generateNumber()
        }

        binding.replaceFragmentsButton.setOnClickListener {
            // Identify the current fragment
            val currentFragment = supportFragmentManager.findFragmentById(R.id.container)

            // Replace the current fragment with the other one
            if (currentFragment is MainFragment) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SecondFragment())
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment())
                    .commit()
            }
        }
    }
}