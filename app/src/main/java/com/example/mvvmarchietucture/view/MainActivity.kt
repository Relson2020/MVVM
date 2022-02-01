package com.example.mvvmarchietucture.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmarchietucture.R
import com.example.mvvmarchietucture.model.Repository
import com.example.mvvmarchietucture.model.RetrofitBuilder
import com.example.mvvmarchietucture.databinding.ActivityMainBinding
import com.example.mvvmarchietucture.viewmodel.MainViewModel
import com.example.mvvmarchietucture.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var textView = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // DataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val apiInterface = RetrofitBuilder.retrofitInstance
        val repositoryInstance = Repository(apiInterface)

        val viewModel =
            ViewModelProvider(this, MainViewModelFactory(repositoryInstance))[MainViewModel::class.java]

        // Observing apiLiveData from the MainViewModel
        viewModel.apiResultLiveData.observe(this) {
            it.forEach{ result ->
                textView += "${result.body}\n\n"
                binding.apiData = textView
            }
        }

        // Clicked listener on the get button
        binding.getButton.setOnClickListener {
            viewModel.get()
        }
    }
}