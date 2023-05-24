package com.example.truecallercoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.truecallercoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var htmlResponse: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        CoroutineScope(Dispatchers.IO).launch {
            htmlResponse = NetworkUtils.fetchHtml(Constants.endpointUrl)
            displayViews(htmlResponse)
        }

    }



    private fun displayViews(htmlStr: String) {
        val displayObjects = listOf(
            DisplayObj(binding.textView1, StringFormatter.show15thChar(htmlStr)),
            DisplayObj(binding.textView2, StringFormatter.show15thCharsArray(htmlStr)),
            DisplayObj(binding.textView3, StringFormatter.showCountPerWord(htmlStr)),
        )



        displayObjects.forEach { obj ->
            CoroutineScope(Dispatchers.Main).launch {
                obj.viewHolder.text = obj.function
            }
        }

    }

}