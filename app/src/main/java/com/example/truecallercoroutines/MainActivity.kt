package com.example.truecallercoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.truecallercoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val htmlResponse: String = NetworkUtils.fetchHtml(Constants.endpointUrl)
            val displays = createDisplays(htmlResponse)
            withContext(Dispatchers.Main) {
                displayViews(displays)
            }
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