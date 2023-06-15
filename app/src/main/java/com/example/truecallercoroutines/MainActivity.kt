package com.example.truecallercoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.truecallercoroutines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchHtml(Constants.endpointUrl)

        viewModel.viewState.observe(this) { htmlResponse ->
            val displays = createDisplays(htmlResponse)
            displayViews(displays)
        }
    }

        private fun createDisplays(htmlStr: String): List<DisplayObj> {
        return listOf(
            DisplayObj(binding.textView1, StringFormatter.showNthChar(htmlStr, Constants.jumpSize)),
            DisplayObj(binding.textView2, StringFormatter.showNthCharsArray(htmlStr, Constants.jumpSize)),
            DisplayObj(binding.textView3, StringFormatter.showCountPerWord(htmlStr)),
        )
    }

    private fun displayViews(displays: List<DisplayObj>) {
        displays.forEach { obj ->
            obj.viewHolder.text = obj.function
        }
    }

}