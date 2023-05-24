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
            displayViews()
        }

    }

    private fun showCountPerWord(): CharSequence {
        return htmlResponse.subSequence(0, 20)
    }

    private fun show15thCharsArray(): CharSequence {
        return htmlResponse.subSequence(0, 20)
    }

    private fun show15thChar(): CharSequence {
        return htmlResponse.subSequence(0, 20)
    }


    private fun displayViews() {
        val displayObjects = listOf(
            DisplayObj(binding.textView1, show15thChar()),
            DisplayObj(binding.textView2, show15thCharsArray()),
            DisplayObj(binding.textView3, showCountPerWord()),
        )



        displayObjects.forEach { obj ->
            CoroutineScope(Dispatchers.Main).launch {
                obj.viewHolder.text = obj.function
            }
        }

    }

}