package com.example.stepperformdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.stepperformdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var position = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.stepView.done(false)

        binding.button.setOnClickListener {
            when (position) {
                0 -> {
                    binding.personalDetails.visibility = View.GONE
                    binding.location.visibility = View.VISIBLE
                    position = 1
                    binding.stepView.done(false)
                    binding.stepView.go(position, true)
                    binding.button.text = "Next"
                }
                1 -> {
                    binding.location.visibility = View.GONE
                    binding.usage.visibility = View.VISIBLE
                    position = 2
                    binding.stepView.done(false)
                    binding.stepView.go(position, true)
                    binding.button.text = "Next"
                }
                2 -> {
                    binding.usage.visibility = View.GONE
                    binding.employment.visibility = View.VISIBLE
                    position = 3
                    binding.stepView.done(false)
                    binding.stepView.go(position, true)
                    binding.button.text = "Next"
                }
                3 -> {
                    binding.employment.visibility = View.GONE
                    binding.repayment.visibility = View.VISIBLE
                    position = 4
                    binding.stepView.done(false)
                    binding.stepView.go(position, true)
                    binding.button.text = "Submit"
                }

                else -> {
                    position = 0
                    binding.stepView.done(true)
                    binding.stepView.go(5, true)

                    // Go to another Activity or Fragment
                }
            }
        }
    }


    @SuppressLint("SetTextI18n")
    override fun onBackPressed() {
        when (position) {
            0 -> {
                super.onBackPressed()
            }
            1 -> {
                binding.location.visibility = View.GONE
                binding.personalDetails.visibility = View.VISIBLE
                position = 0
                binding.stepView.done(false)
                binding.stepView.go(position, true)
                binding.button.text = "Next"
            }
            2 -> {
                binding.usage.visibility = View.GONE
                binding.location.visibility = View.VISIBLE
                position = 1
                binding.stepView.done(false)
                binding.stepView.go(position, true)
                binding.button.text = "Next"
            }
            3 -> {
                binding.employment.visibility = View.GONE
                binding.usage.visibility = View.VISIBLE
                position = 2
                binding.stepView.done(false)
                binding.stepView.go(position, true)
                binding.button.text = "Next"
            }
            else -> {
                binding.repayment.visibility = View.GONE
                binding.employment.visibility = View.VISIBLE
                position = 3
                binding.stepView.done(false)
                binding.stepView.go(position, true)
                binding.button.text = "Next"
            }
        }
    }
}